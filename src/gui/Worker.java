package gui;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Worker extends SwingWorker<Void, Integer> {

    private final String in;
    private final String out;
    private final JProgressBar progreso;
    private final JLabel jl;
    private String text;

    public void setText(String text) {
        this.text = text;
    }
    

    public Worker(String in, String out, JProgressBar progreso, JLabel jl) {
        this.in = in;
        this.out = out;
        this.progreso = progreso;
        this.jl = jl;
    }


    @Override
    protected Void doInBackground() throws Exception {
        ZipCompressor zip = new ZipCompressor();
        zip.compressFolder(in, out + "\\folder.zip", this);
        return null;
    }

    @Override
    protected void done() {

        if (isCancelled()) {
            JOptionPane.showMessageDialog(progreso.getParent(), "Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(progreso.getParent(), "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void process(List<Integer> chunks) {
        int i = chunks.get(chunks.size() - 1);
        progreso.setValue(i);
        jl.setText(text);
    }

    public void cuenta(int i) {
        publish(i);
    }

    public void setMax(int max) {
        progreso.setMaximum(max);
    }

    
}
