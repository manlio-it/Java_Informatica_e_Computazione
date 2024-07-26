public class Automezzo 
{

	private String Marca;
	private String Modello;
	private String Targa;
	private int AnnoImmatricolazione;
	private int AnnoRevisione;
	
	public Automezzo (String Marca, String Modello, String Targa, int AnnoImmatricolazione, int AnnoRevisione)
	{
		this.Marca = Marca;
		this.Modello = Modello;
		this.Targa = Targa;
		this.AnnoImmatricolazione = AnnoImmatricolazione;
		this.AnnoRevisione = AnnoRevisione;
	}
	
	
	public String GetMarca ()
	{
		return this.Marca;
	}
	public String GetModello ()
	{
		return this.Modello;
	}
	public String GetTarga ()
	{
		return this.Targa;
	}
	public int GetAnnoImmatricolazione ()
	{
		return this.AnnoImmatricolazione;
	}
	public int GetAnnoRevisione ()
	{
		return this.AnnoRevisione;
	}
}
