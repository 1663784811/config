package cn.cyyaw.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FtpUtils {

    @Value("${ftp.hostname}")
    public String hostname;
    @Value("${ftp.port}")
    public Integer port;
    @Value("${ftp.username}")
    public String username;
    @Value("${ftp.password}")
    public String password;
    @Value("${ftp.directory}")
    public String directory;

    public FTPClient ftpClient = null;


    /**
     * 初始化ftp服务器
     */
    public void initFtpClient() {
        try {
            ftpClient = new FTPClient();
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(hostname, port);
            ftpClient.login(username, password);
            ftpClient.changeWorkingDirectory(directory);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                throw new WhyException("连接FTP失败");
            }
        } catch (Exception e) {
            throw new WhyException("连接FTP失败");
        }
    }

    /**
     * 上传文件
     *
     * @param fileName       上传到ftp的文件名
     * @param originfilename 待上传文件的名称（绝对地址） *
     * @return
     */
    public boolean uploadFile(String fileName, String originfilename) {
        InputStream inputStream = null;
        try {
            System.out.println("开始上传文件");
            inputStream = new FileInputStream(new File(originfilename));
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            System.out.println("上传文件成功");
        } catch (Exception e) {
            throw new WhyException("FTP上传文件失败");
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 上传文件
     *
     * @param pathname    ftp服务保存地址
     * @param fileName    上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
        boolean flag = false;
        try {
            System.out.println("开始上传文件");
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("上传文件成功");
        } catch (Exception e) {
            System.out.println("上传文件失败");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 下载文件 *
     *
     * @param pathname  FTP服务器文件目录 *
     * @param filename  文件名称 *
     * @param localpath 下载后的文件路径 *
     * @return
     */
    public boolean downloadFile(String pathname, String filename, String localpath) {
        boolean flag = false;
        OutputStream os = null;
        try {
            System.out.println("开始下载文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile file : ftpFiles) {
                if (filename.equalsIgnoreCase(file.getName())) {
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            System.out.println("下载文件成功");
        } catch (Exception e) {
            System.out.println("下载文件失败");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * 删除文件 *
     *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return
     */
    public boolean deleteFile(String pathname, String filename) {
        boolean flag = false;
        try {
            System.out.println("开始删除文件");
            initFtpClient();
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            System.out.println("删除文件成功");
        } catch (Exception e) {
            System.out.println("删除文件失败");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        FtpUtils ftp = new FtpUtils();
        ftp.downloadFile("ftpFile/data", "123.docx", "F://");
        ftp.deleteFile("ftpFile/data", "123.docx");
        System.out.println("ok");
    }


}
