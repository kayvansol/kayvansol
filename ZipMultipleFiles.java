public class ZipMultipleFiles {
    
    public static void main(String[] args) throws IOException {
        
        List<String> srcFiles = Arrays.asList("test1.txt", "test2.txt");
        FileOutputStream fos = new FileOutputStream("multiCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            
            fis.close();
        }
        
        zipOut.close();
        fos.close();
    }
}
