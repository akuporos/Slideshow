package application;

import java.io.File;
import java.util.ArrayList;

//TODO: ������� ����� ��� ������� ������
//TODO: ������� ������ ��� ������������ ������������
public class Project
{
	Music music;
	Video video;
	Picture picture;
	private ArrayList<MediaFiles> files  = new ArrayList<MediaFiles>();

	public void loadMusic(File file)
	{
		music = new Music();
		music.loadFile(file);
	}

	public void  loadVideo(File file)
	{
		video = new Video();
		video.loadFile(file);
		files.add(video);
	}

	public void  loadImage(File file)
	{
		picture = new Picture();
		picture.loadFile(file);
		files.add(picture);
	}

	public void setTime(String from, String to, int i)
	{
		//� ������ ����������� ������� ����������

		if(files.get(i).isImage())
		{
			Picture current_picture  = (Picture)files.get(i);
			current_picture.setTime(from, to);
		}
	}

	public  ArrayList<MediaFiles> getContent()
	{
		return files;
	}

	public void swap(int first, int second){
		MediaFiles tmp_media_files = files.get(first);
		files.set(first, files.get(second));
		files.set(second, tmp_media_files);
	}

	public void remove(int numOfElement){
		if(numOfElement < 0) new Exception("Project::remove: You cannot delete an element with a negative number");
		if(numOfElement >= files.size()) new Exception("Project::remove: You cannot delete an element number greater than the array size");

		files.remove(numOfElement);
	}
}
