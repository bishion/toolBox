package com.bizi.tools.ftp;

import com.bizi.tools.exception.BaseAppException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

public class FtpUtil {

	public static FTPClient getFtpClient(String ip, String username, String password,int port) throws BaseAppException {
		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(ip, port);

			ftpClient.login(username,password);
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				ftpClient.disconnect();
				throw new BaseAppException("FTP00001","ftp连接未激活");
			}
			return ftpClient;
		} catch (IOException e) {
			throw new BaseAppException(e);
		}
	}
	public static FTPClient getFtpClient(String ip, String username, String password) throws BaseAppException {
		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(ip);

			ftpClient.login(username,password);
			return ftpClient;
		} catch (IOException e) {
			throw new BaseAppException(e);
		}
	}
	/**
	 * Description: 向FTP服务器上传文件
	 * @param remotePath FTP服务器保存目录
	 * @param filename 上传到FTP服务器上的文件名
	 * @param input 输入流
	 */
	public void uploadFile(FTPClient ftpClient,String remotePath,String filename,InputStream input) throws BaseAppException {
		try {

			ftpClient.changeWorkingDirectory(remotePath);
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(filename, input);
			input.close();
			ftpClient.logout();

		} catch (IOException e) {
			throw new BaseAppException(e);
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					throw new BaseAppException(e);

				}
			}
		}

	}

	/**
	 * Description: 从FTP服务器下载文件
	 * @param remotePath
	 * @param filename
	 * @param ous
	 * @return
	 */
	public void downloadFile(FTPClient ftpClient,String remotePath,String filename,OutputStream  ous) throws BaseAppException {
		try {
			ftpClient.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
			ftpClient.enterLocalPassiveMode();
			FTPFile[] fs = ftpClient.listFiles(filename);
			//判断文件是否存在
			if(fs.length == 0){
				ftpClient.disconnect();
				throw new BaseAppException("FTP00002","文件不存在");
			}
			for (FTPFile ff : fs)
			{
				if (ff.getName().equals(filename))
				{

					ftpClient.retrieveFile(ff.getName(), ous);
					ous.close();
				}
			}
			ftpClient.logout();

		} catch (SocketException e) {
			throw new BaseAppException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			if (ftpClient.isConnected())
			{
				try
				{
					ftpClient.disconnect();
				}
				catch (IOException e)
				{
					throw new BaseAppException(e);
				}
			}
		}
	}

	/**
	 * Description: 从FTP服务器删除文件
	 * @param remotePath
	 * @param filename
	 * @return
	 */
	public boolean deleteFile(FTPClient ftpClient,String remotePath,String filename)
	{
		boolean result=false;
		try{
			// 转移到FTP服务器目录
			ftpClient.changeWorkingDirectory(remotePath);
			result = ftpClient.deleteFile(remotePath + "/" + filename);
			ftpClient.logout();
		}
		catch (IOException e){
			result = false;
			throw new RuntimeException(e);
		}
		finally{
			if (ftpClient.isConnected()){
				try{
					ftpClient.disconnect();
				}catch (IOException e){
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}

}
