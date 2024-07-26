import java.util.Scanner;
import java.util.Calendar;

public class Main
{
	
	public static void main(String[] args) {
	int caricato = 0;
	System.out.println("Menù di scelta:");
	System.out.println("0 - Inserimento N automezzi"); //fatto
	System.out.println("1 - Aggiunta"); //fatto
	System.out.println("2 - Cancellazione"); //fatto
	System.out.println("3 - Ricerca tramite targa"); //fatto
	System.out.println("4 - Ricerca per revisione"); //fatto
	System.out.println("5 - Stampa di tutti i modelli presenti (su System.out)");
	System.out.println("6 - Stampa di tutti i modelli presenti (su file)");
	System.out.println ("7 - Esci");
	
	GestioneAutomezzi gestione = new GestioneAutomezzi();
	
	Scanner in = new Scanner(System.in);
	String scelta;
	int decisione = 0;
	while (true)
	{
		scelta = in.next();
        try
        {
    		decisione = Integer.parseInt(scelta);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Input non valido, riprovare!");
            decisione = 10;
            continue;
        }
		
		if (decisione == 0)
		{
			if (caricato == 0)
			{
				gestione.Caricamento();
				caricato = 1;
			}
			else
				System.out.println("Il parco automezzi è già stato caricato. Se si vuole caricare un altro parco, riavviare il programma.");
		}
		else if (decisione == 1)
		{
			System.out.println("Inserire in ordine: Marca, Modello e Targa (con le iniziali maiuscole)");
			String Marca = in.next();
			String Modello = in.next();
			String Targa = in.next();
			int anno = Calendar.getInstance().get(Calendar.YEAR);
			gestione.Aggiunta(Marca, Modello, Targa, anno, anno);
		}
		else if (decisione == 2)
		{
			System.out.println("Inserire la targa dell'automezzo da cancellare");
			String Targa = in.next();
			gestione.Cancellazione(Targa);
		}
		else if (decisione == 3)
		{
			System.out.println("Inserire la targa dell'automezzo da cercare");
			String Targa = in.next();
			gestione.RicercaTarga(Targa);
		}
		else if (decisione == 4)
		{
			System.out.println("Iniziata la ricerca di tutti i veicoli in cui l'anno dell'ultima revisione: ");
			System.out.println ("-> Coincide con l’anno di immatricolazione ed è antecedente di 4 anni rispetto all’anno corrente");
			System.out.println("oppure");
			System.out.println("-> E' antecedente di 2 anni rispetto all’anno corrente");
			System.out.println ("");
			int anno = Calendar.getInstance().get(Calendar.YEAR);
			gestione.RicercaRevisione(anno);
			
		}
		else if (decisione == 5)
		{
			gestione.StampaModelliSystem();
		}
		else if (decisione == 6)
		{
			gestione.StampaModelliFile();
		}	
		else if (decisione == 7)
		{
			System.out.println("Fine esecuzione programma.");
			System.out.println("Buona giornata!");
			System.exit(0);
		}
		else
		{
			System.out.println("Input non valido, riprovare!");
		}
	}
		
	}
}
