package gui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.*;

public class ZipCompressor {

    private List<String> files;
    private String in;
    private String out;

    private final int BUFFER_SIZE = 512;

    public ZipCompressor(String in, String out) {
        this.in = in;
        this.out = out;
        files = new ArrayList<>();
        generateFileList();
    }

    public void compressFolder(Worker work) {
        try {
            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin;
            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = new FileOutputStream(out);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            // Buffer de transferencia para mandar datos a comprimir
            byte[] data = new byte[BUFFER_SIZE];
            Iterator iterator = files.iterator();

            // Instanciamos contador para la barra de progreso
            int i = 0;

            while (iterator.hasNext()) {
                // ¿El usuario ha pulsado cancelar?
                if (work.isTerminated()) break;
                
                String filename = (String) iterator.next();

                // Archivo que esta siendo comprimido actualmente
                work.setText(filename.substring(filename.lastIndexOf("\\") + 1));

                FileInputStream fi = new FileInputStream(filename);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);

                // Creamos una entrada en ZIP con el nombre de fichero
                // sin crear carpetas adicionales
                String single = Paths.get(filename).getFileName().toString();

                ZipEntry entry = new ZipEntry(single);
                out.putNextEntry(entry);

                // LLamada externa al método publish
                work.setPublish(100 * i / files.size());

                // Leemos datos desde el archivo origen y los mandamos al archivo destino
                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                    out.write(data, 0, count);
                }
                // Cerramos el archivo origen, ya enviado a comprimir
                origin.close();

                // Actualizamos contador de la barra de progreso
                i++;
            }
            // Cerramos el archivo zip
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    private void generateFileList() {
        File stream = new File(in);
        File[] filelist = stream.listFiles();
        for (File file : filelist) {
            if (file.isFile()) {
                files.add(file.getAbsolutePath());
            }
        }
    }
}
