package gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Worker extends SwingWorker<Void, Integer> {

    private final String in;
    private final String out;
    private final JProgressBar progreso;
    private final int max = 1000;

    public Worker(String in, String out, JProgressBar bar) {
        this.in = in;
        this.out = out;
        this.progreso = bar;
        progreso.setMaximum(max);
    }

    @Override
    protected Void doInBackground() throws Exception {

        for (int i = 0; i < max; i++) {
            Thread.sleep(10); 
            publish(i);
        }
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
        System.out.println(i);
    }

}
