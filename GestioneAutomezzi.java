import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class GestioneAutomezzi
{

	ArrayList<Automezzo> automezzi = new ArrayList<Automezzo>();
	
	public void Caricamento ()
	{
		try
		{
			File mioFile = new File("input.txt");
		    Scanner lettura = new Scanner(mioFile);
		    String Riga;
		    while (lettura.hasNextLine())
		    {
		    	Riga = lettura.nextLine();
			    String Parts [] = Riga.split(", ");
			    String Marca = Parts[0];
			    String Modello = Parts[1];
			    String Targa = Parts[2];
			    int AnnoImmatricolazione = Integer.parseInt(Parts [3]);
			    int AnnoRevisione = Integer.parseInt(Parts [4]);
			    Automezzo aggiungere = new Automezzo(Marca, Modello, Targa, AnnoImmatricolazione, AnnoRevisione);
			    automezzi.add(aggiungere);
		    }
		    lettura.close();
		    System.out.println("Caricamento avvenuto con successo.");
		    
		}
		 catch (FileNotFoundException e) 
		 {
			 System.out.println("Errore durante il caricamento, file input.txt non trovato.");
			 e.printStackTrace();
		 }
	}
	
	public void Aggiunta (String Marca, String Modello, String Targa, int AnnoImmatricolazione, int AnnoRevisione)
	{
		
		Automezzo aggiungere = new Automezzo(Marca, Modello, Targa, AnnoImmatricolazione, AnnoRevisione);
		automezzi.add(aggiungere);
		System.out.println("Aggiunta avvenuta con successo.");

	}
	
	public void Cancellazione (String Targa)

	{
		for (int i = 0; i < (automezzi.size()) ; i++)
		{
			if (Targa.equals(automezzi.get(i).GetTarga()))
			{
				automezzi.remove(i);
				System.out.println("Cancellazione avvenuta con successo.");
				return;
			}
		}
		System.out.println("Non è stato trovato nessun automezzo con questa targa.");
	}
	
	public void RicercaTarga (String Targa)
	{
		for (int i = 0; i < (automezzi.size()) ; i++)
		{
			if (Targa.equals(automezzi.get(i).GetTarga()))
			{
				System.out.println("Automezzo trovato:");
				System.out.println("Marca: " + automezzi.get(i).GetMarca());
				System.out.println("Modello: " + automezzi.get(i).GetModello());
				System.out.println("Targa: " + automezzi.get(i).GetTarga());
				System.out.println("Anno Immatricolazione : " + automezzi.get(i).GetAnnoImmatricolazione());
				System.out.println("Anno Revisione : " + automezzi.get(i).GetAnnoRevisione());
				return;
			}
		}
		System.out.println("Non è stato trovato nessun automezzo con questa targa.");
	}
	
	public void RicercaRevisione (int anno)
	{
		boolean presenti = false;
		for (int i = 0; i < (automezzi.size()) ; i++)
		{
			if (((automezzi.get(i).GetAnnoImmatricolazione() == automezzi.get(i).GetAnnoRevisione()) && ((anno - automezzi.get(i).GetAnnoRevisione()) == 4)) || (anno - automezzi.get(i).GetAnnoRevisione() == 2))
			{
				System.out.println("Automezzo trovato:");
				System.out.println("Marca: " + automezzi.get(i).GetMarca());
				System.out.println("Modello: " + automezzi.get(i).GetModello());
				System.out.println("Targa: " + automezzi.get(i).GetTarga());
				System.out.println("Anno Immatricolazione : " + automezzi.get(i).GetAnnoImmatricolazione());
				System.out.println("Anno Revisione : " + automezzi.get(i).GetAnnoRevisione());
				System.out.println("-------------");
				presenti = true;
			}
		}
		if (!presenti == true) 
		{
			System.out.println();
			System.out.println("Non è stato trovato nessun automezzo che soddisfa le condizioni richieste.");
		}
	}

	public void StampaModelliSystem ()
	{
		boolean presenza = false;
		ArrayList<String> Modelli = new ArrayList<String>();
		for (int i = 0; i < (automezzi.size()) ; i++)
		{
			presenza = false;
			for (int c = 0; c < (Modelli.size()); c++)
			{
				if (Modelli.get(c).equals(automezzi.get(i).GetModello()))
					presenza = true;
			}
			if (presenza == false)
			{
				Modelli.add(automezzi.get(i).GetModello());
			}
		}
		if (0 == Modelli.size())
		{
			System.out.println ("Non sono presenti automezzi, aggiungerne uno o inserire il parco automezzi.");
			return;
		}
		System.out.println("I modelli presenti sono: ");
		for (int b = 0; b < (Modelli.size()); b++)
		{
			System.out.println(Modelli.get(b));
			
		}
		System.out.println("");
		System.out.println("Fine stampa su System.out");
	}

	public void StampaModelliFile ()
	{
        int conta = 0;
		boolean presenza = false;
		ArrayList<String> Modelli = new ArrayList<String>();
		for (int i = 0; i < (automezzi.size()) ; i++)
		{
			presenza = false;
			for (int c = 0; c < (Modelli.size()); c++)
			{
				if (Modelli.get(c).equals(automezzi.get(i).GetModello()))
					presenza = true;
			}
			if (presenza == false)
			{
				Modelli.add(automezzi.get(i).GetModello());
			}
		}
		if (0 == Modelli.size())
		{
			System.out.println ("Non sono presenti automezzi, aggiungerne uno o inserire il parco automezzi.");
			return;
		}
		try 
		{
	         File mioFile = new File("output.txt");
	         mioFile.delete();
			String data;
			for (int b = 0; b < (Modelli.size()); b++)
			{	
			 data = Modelli.get(b) + "\n";
	         mioFile.createNewFile();
	         FileWriter aggiunta = new FileWriter(mioFile.getName(),true);
	         BufferedWriter bw = new BufferedWriter(aggiunta);
	         bw.write(data);
	         bw.close();
	         conta ++;
			}
	    }
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Errore.");
	    }
        System.out.println("Stampati con successo " + conta + " modelli su output.txt");
		
		
	}
}
