package filemerge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMerge {

	public static void main(String[] args) throws IOException {
		
		int file_num = Integer.parseInt(args[0]);
		//@para args[0] the file number
		//@para args[1] the first file name
		//@para args[2] the second file name
		//@para args[3] the output file name
		if (file_num == 2)
		{
			String file1 = args[1];
			File file_in1 = new File(file1);
			InputStream reader1 = new FileInputStream(file_in1);
			String file2 = args[2];
			File file_in2 = new File(file2);
			InputStream reader2 = new FileInputStream(file_in2);
			String file3 = args[3];
			File file_in3 = new File(file3);
			OutputStream writer = new FileOutputStream(file_in3);
			merge2(reader1,reader2,writer);
		}
		//@para args[0] the file number
		//@para args[1] the first file name
	    //@para args[2] the second file name
		//@para args[3] the third file name
		//@para args[4] the output file name
		else
		{
			String file1 = args[1];
			File file_in1 = new File(file1);
			InputStream reader1 = new FileInputStream(file_in1);
			String file2 = args[2];
			File file_in2 = new File(file2);
			InputStream reader2 = new FileInputStream(file_in2);
			String file3 = args[3];
			File file_in3 = new File(file3);
			InputStream reader3 = new FileInputStream(file_in3);
			String file4 = args[4];
			File file_in4 = new File(file4);
			OutputStream writer = new FileOutputStream(file_in4);
			merge3(reader1, reader2, reader3, writer);
		}	
	}
    public static void merge2(InputStream reader1, InputStream reader2, OutputStream writer) throws IOException
    {
    	   int read_length = 0;
    	   int block1 =0;
    	   int block2 =0;
    	   byte[] bb = new byte[4*1024];
    	   read_length =  reader1.read(bb);
    	   while (read_length != -1)
    	   {
    		     block1++;
    		     writer.write(bb,0,read_length);
    		     read_length = reader1.read(bb);
    	   }
    	   System.out.println("The blocks of file1 are: "+block1);
    	   read_length =  reader2.read(bb);
    	   while (read_length != -1)
    	   {
    		     block2++;
    		     writer.write(bb,0,read_length);
    		     read_length = reader2.read(bb);
    	   }
    	   System.out.println("The blocks of file2 are: "+block2);
    	   reader1.close();
    	   reader2.close();
    	   writer.close();
    }
    
    public static void merge3(InputStream reader1, InputStream reader2, InputStream reader3, OutputStream writer) throws IOException
    {
    	   int read_length = 0;
    	   int block1 =0;
    	   int block2 =0;
    	   int block3 =0;
    	   byte[] bb = new byte[4*1024];
    	   read_length =  reader1.read(bb);
    	   while (read_length != -1)
    	   {
    		     block1++;
    		     writer.write(bb,0,read_length);
    		     read_length = reader1.read(bb);
    	   }
    	   System.out.println("The blocks of file1 are: "+block1);
    	   read_length =  reader2.read(bb);
    	   while (read_length != -1)
    	   {
    		     block2++;
    		     writer.write(bb,0,read_length);
    		     read_length = reader2.read(bb);
    	   }
    	   System.out.println("The blocks of file2 are: "+block2);
    	   read_length =  reader3.read(bb);
    	   while (read_length != -1)
    	   {
    		     block3++;
    		     writer.write(bb,0,read_length);
    		     read_length = reader3.read(bb);
    	   }
    	   System.out.println("The blocks of file3 are: "+block3);
    	   reader1.close();
    	   reader2.close();
    	   reader3.close();
    	   writer.close();
    }
}
