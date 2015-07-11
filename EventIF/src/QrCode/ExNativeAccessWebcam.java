package QrCode;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.smaxe.uv.media.VideoFrameFactory;
import com.smaxe.uv.media.core.VideoFrame;
import com.smaxe.uv.media.swing.JVideoScreen;
import com.smaxe.uv.na.WebcamFactory;
import com.smaxe.uv.na.webcam.IWebcam;

/**
 * <code>ExNativeAccessWebcam</code> - {@link IWebcam} usage example.
 * 
 * @author Andrei Sochirca
 * @see <a href="http://www.smaxe.com/product.jsf?id=juv-webcam-sdk" target="_blank">JUV Webcam SDK</a>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ExNativeAccessWebcam extends Object
{
	
	static File file = null;
    /**
     * Entry point.
     * 
     * @param args
     * @throws Exception if an exception occurred
     */
    public ExNativeAccessWebcam() throws Exception
    {
    	
    	
        final JComboBox webcamComboBox = new JComboBox();
        
        final JFrame frame = new JFrame();
        
        final JPanel content = new JPanel(new FlowLayout());
        
        content.setBorder(new EmptyBorder(8, 8, 8, 8));
        content.setPreferredSize(new Dimension(640, 48));
        
        content.add(new JLabel("Webcam: ", JLabel.RIGHT));
        content.add(webcamComboBox);
        content.add(new JButton(new AbstractAction("Open")
        {
            private final static long serialVersionUID = -4792981545160764997L;
            
            public void actionPerformed(ActionEvent e)
            {
                final IWebcam webcam = (IWebcam) webcamComboBox.getSelectedItem();
                if (webcam == null) return;
                
                final AtomicReference<JFrame> frameRef = new AtomicReference<JFrame>();
                
                final JVideoScreen videoScreen = new JVideoScreen();
                
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        final AtomicReference<VideoFrame> lastFrameRef = new AtomicReference<VideoFrame>();
                        
                        try
                        {
                            webcam.open(new IWebcam.FrameFormat(320, 240), new IWebcam.IListener()
                            {
                                private VideoFrame lastFrame = new VideoFrame(0, 0, null);
                                
                                public void onVideoFrame(final VideoFrame frame)
                                {
                                    SwingUtilities.invokeLater(new Runnable()
                                    {
                                        public void run()
                                        {
                                            videoScreen.setFrame(frame);
                                            
                                            if (lastFrame.width != frame.width || lastFrame.height != frame.height)
                                            {
                                                final JFrame frame = frameRef.get();
                                                
                                                if (frame != null) frame.pack();
                                            }
                                            
                                            lastFrame = frame;
                                            
                                            lastFrameRef.set(lastFrame);
                                        }
                                    });
                                }
                            });
                            
                            final IWebcam.FrameFormat[] supportedFormats = webcam.getFormats();
                            
                            if (supportedFormats != null)
                            {
                                System.out.println("Webcam: " + webcam.getName());
                                System.out.println("Supported formats: ");
                                
                                for (IWebcam.FrameFormat format : supportedFormats)
                                {
                                    System.out.println("=> " + format);
                                }
                            }
                            
                            webcam.startCapture();
                            
                            SwingUtilities.invokeLater(new Runnable()
                            {
                                public void run()
                                {
                                    final JFrame frame = new JFrame();
                                    
                                    frameRef.set(frame);                                    
                                    
                                    frame.getContentPane().setLayout(new BorderLayout());
                                    frame.getContentPane().add(videoScreen, BorderLayout.CENTER);
                                    
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setResizable(false);
                                    frame.setTitle(webcam.getName());
                                    
                                    videoScreen.addMouseListener(new MouseAdapter()
                                    {
                                        @Override
                                        public void mouseClicked(final MouseEvent e)
                                        {
                                            final int clickCount = e.getClickCount();
                                            final Object source = e.getSource();
                                            
                                            switch (clickCount)
                                            {
                                                case 1:
                                                {
                                                    if (SwingUtilities.isRightMouseButton(e))
                                                    {
                                                        JPopupMenu popup = new JPopupMenu();
                                                        
                                                        popup.add(new AbstractAction("Take Snapshot")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                new SnapshotDialog(VideoFrameFactory.clone(lastFrameRef.get())).setVisible(true);
                                                            }
                                                        });
                                                        
                                                        popup.addSeparator();
                                                        
                                                        popup.add(new AbstractAction("Mirror")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                videoScreen.mirror(!videoScreen.getMirrorFlag());
                                                            }
                                                        });
                                                        
                                                        popup.add(new AbstractAction("Flip")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                videoScreen.flip(!videoScreen.getFlipFlag());
                                                            }
                                                        });
                                                        
                                                        popup.addSeparator();
                                                        
                                                        popup.add(new AbstractAction("160x120")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                webcam.setFrameFormat(new IWebcam.FrameFormat(160, 120));
                                                            }
                                                        });
                                                        
                                                        popup.add(new AbstractAction("320x240")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                webcam.setFrameFormat(new IWebcam.FrameFormat(320, 240));
                                                            }
                                                        });
                                                        
                                                        popup.add(new AbstractAction("640x480")
                                                        {
                                                            private final static long serialVersionUID = 0L;
                                                            
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                webcam.setFrameFormat(new IWebcam.FrameFormat(640, 480));
                                                            }
                                                        });
                                                        
                                                        popup.show((Component) source, e.getX(), e.getY());
                                                    }
                                                } break;
                                            }
                                        }
                                    });
                                    
                                    frame.addWindowListener(new WindowAdapter()
                                    {
                                        @Override
                                        public void windowClosing(WindowEvent e)
                                        {
                                            webcam.close();
                                        }
                                    });
                                    
                                    frame.pack();
                                    frame.setVisible(true);
                                }
                            });
                        }
                        catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog(frame,
                                    ex.getMessage(), ex.getMessage(), JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }).start();
            }
        }));
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(content);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Webcam capture options");
        
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        
        frame.pack();
        frame.setVisible(true);
        
        webcamComboBox.setModel(new WebcamComboModel(WebcamFactory.getWebcams()));
    }
    
    /**
     * <code>SnapshotDialog</code> - snapshot dialog.
     */
    private final static class SnapshotDialog extends JDialog
    {
        private final static long serialVersionUID = -3136925779409522531L;
        
        /**
         * Constructor.
         * 
         * @param videoFrame
         */
        public SnapshotDialog(final VideoFrame videoFrame)
        {
            this.setLayout(new BorderLayout());
            this.setResizable(false);
            this.setTitle("Photo snapshot");
            
            JVideoScreen videoScreen = new JVideoScreen();
            
            videoScreen.setFrame(videoFrame);
            
            videoScreen.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(final MouseEvent e)
                {
                    final int clickCount = e.getClickCount();
                    final Object source = e.getSource();
                    
                    switch (clickCount)
                    {
                        case 1:
                        {
                            if (SwingUtilities.isRightMouseButton(e))
                            {
                                JPopupMenu popup = new JPopupMenu();
                                
                                popup.add(new AbstractAction("Save As..")
                                {
                                    private final static long serialVersionUID = 0L;
                                    
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        JFileChooser fileChooser = new JFileChooser();
                                        
                                        fileChooser.setCurrentDirectory(new File("."));
                                        
                                        final int rv = fileChooser.showSaveDialog(getParent());
                                        
                                        if (rv != JFileChooser.APPROVE_OPTION) return;
                                        
                                        file = fileChooser.getSelectedFile();
                                        
                                        new Thread(new Runnable()
                                        {
                                            public void run()
                                            {
                                                try
                                                {
                                                    VideoFrameFactory.saveAsJpg(file, videoFrame);
                                                    try {
                                                    	System.out.println(file.getAbsolutePath());
														ExNativeAccessWebcam.lerqrcodeju();
													} catch (NotFoundException
															| WriterException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
                                                   
                                                }
                                                catch (IOException e)
                                                {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }).start();
                                    }
                                });
                                
                                popup.show((Component) source, e.getX(), e.getY());
                            }
                        } break;
                    }
                }
            });
            
            this.add(videoScreen, BorderLayout.CENTER);
            this.pack();
        }
    }
    
    /**
     * <code>WebcamComboModel</code> - webcam combo model.
     */
    private final static class WebcamComboModel extends AbstractListModel implements ComboBoxModel
    {
        private final static long serialVersionUID = -8627944517955777531L;
        
        // fields
        private final List<IWebcam> devices;
        // state
        private Object selected = null;
        
        /**
         * Constructor.
         * 
         * @param devices
         */
        public WebcamComboModel(List<IWebcam> devices)
        {
            this.devices = devices;
        }
        
        // MutableComboBoxModel implementation
        
        public void setSelectedItem(final Object item)
        {
            this.selected = item;
        }
        
        public Object getSelectedItem()
        {
            return selected;
        }
        
        public Object getElementAt(int index)
        {
            return devices.get(index);
        }
        
        public int getSize()
        {
            return devices.size();
        }
    }
    
 

	public static void lerqrcodeju() throws WriterException, IOException,
		NotFoundException {
	String filePath = file.getAbsolutePath();
	String charset = "UTF-8"; // or "ISO-8859-1"
	Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
	hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	System.out.println("Data read from QR Code: "
			+ readQRCode(filePath, charset, hintMap));
	
	}
		
		public static String readQRCode(String filePath, String charset, Map hintMap)
				throws FileNotFoundException, IOException, NotFoundException {
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(
							ImageIO.read(new FileInputStream(filePath)))));
			com.google.zxing.Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,hintMap);
			return qrCodeResult.getText();
		}
    
}