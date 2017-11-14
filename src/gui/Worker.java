package gui;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Worker extends SwingWorker<Boolean, Integer> {

    private final ZipCompressor zip;
    private final JProgressBar progress;
    private final JLabel label;
    private final JButton compressButton;
    private final JButton cancelButton;
    private String text;

    public Worker(ZipCompressor zip, JProgressBar progress, JLabel label, JButton compressButton, JButton cancelButton) {
        this.zip = zip;
        this.progress = progress;
        this.label = label;
        this.compressButton = compressButton;
        this.cancelButton = cancelButton;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        compressButton.setEnabled(false);
        cancelButton.setEnabled(true);
        zip.compressFolder(this);

        return true;
    }

    @Override
    protected void done() {

        if (isCancelled()) {
            JOptionPane.showMessageDialog(progress.getParent(), "Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            progress.setValue(0);
            label.setText("");
            cancelButton.setEnabled(false);
        } else {
            progress.setValue(100);
            JOptionPane.showMessageDialog(progress.getParent(), "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            progress.setValue(0);
            label.setText("");
            cancelButton.setEnabled(false);
        }
    }

    @Override
    protected void process(List<Integer> chunks) {
        int i = chunks.get(chunks.size() - 1);
        progress.setValue(i);
        label.setText(text);
    }

    public void setPublish(int i) {
        publish(i);
    }

    public boolean isTerminated() {
        return this.isCancelled();
    }

}
