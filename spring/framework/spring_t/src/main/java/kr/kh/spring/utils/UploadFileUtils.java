package kr.kh.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	/**
	 * ������ ���ε��ϴ� �޼ҵ�
	 * @param uploadPath ���ε��� ���
	 * @param originalName ���� ���ϸ�
	 * @param fileData ���ε��� ������ ���� ������
	 * @return ���ε�� ��ο� UUID�� ���Ե� ���ϸ�
	 * @throws Exception 
	 */
    public static String uploadFile(String uploadPath, String originalName, byte[]
            fileData)throws Exception{
    	
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() +"_" + originalName;
        //��¥�� �̿��Ͽ� ������ �����ؼ� ���� => 2025-03-26 => 2025���� > 03���� > 26������ �����Ͽ� ��θ� ����
        String savedPath = calcPath(uploadPath);
        //�������� ���ε� ��ο� ��¥ ��θ� �̿��Ͽ� �� ������ ����
        File target = new File(uploadPath + savedPath, savedName);
        //���ε��� ���� �����͸� �̿��Ͽ� ���縦 ����
        FileCopyUtils.copy(fileData, target);
        //��¥ ������ ���ε�� ���ϸ��� �ִ� ���ڿ��� ������. \\��� /�� ��ȯ�ؼ� ������
        String uploadFileName = getFileName(savedPath, savedName);
        return uploadFileName;
    }

    private static String calcPath(String uploadPath) {
    	//���� �ð��� Ķ���� ��ü�� ������
        Calendar cal = Calendar.getInstance();

        //���� �����ؼ� �տ� �����ڸ� �߰�. \\2025
        //File.separator : ������ ���� ���̸� �����ϴ� ���ڿ�
        String yearPath = File.separator+cal.get(Calendar.YEAR);
        //��� ���� �����ؼ� �տ� �����ڸ� �߰�. \\2025\\03
        String monthPath = yearPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        // \\2025\\03\\26
        String datePath = monthPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        
        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;

    }
    /**
     * uploadPath �ȿ� paths �������� ������ �����ϴ� �޼ҵ�
     * @param uploadPath �������� ������� �޼ҵ�
     * @param paths ���� ������
     */
    private static void makeDir(String uploadPath, String... paths) {
    	//�������� ������ ��, ��, �������� ���� �ʿ䰡 ����
        if(new File(uploadPath + paths[paths.length-1]).exists())
            return;
        for(String path : paths) {
            File dirPath = new File(uploadPath + path);
            if( !dirPath.exists())
                dirPath.mkdir();
        }
    }
    private static String getFileName(String path, String fileName)
            throws Exception{
    	// \\2025\\03\\26\\UUID_a.jpg
        String iconName = path + File.separator + fileName;
        // /2025/03/26/UUID_a.jpg
        return iconName.replace(File.separatorChar, '/');
    }
    public static void deleteFile(String uploadPath, String fi_name) {
    	// /2025/03/26/UUID_a.jpg => \\2025\\03\\26\\UUID_a.jpg
		fi_name = fi_name.replace('/', File.separatorChar);
		File file = new File(uploadPath + fi_name);
		//������ �����ϸ� ������ ����
		if(file.exists()) {
		file.delete();
		}
	}
}