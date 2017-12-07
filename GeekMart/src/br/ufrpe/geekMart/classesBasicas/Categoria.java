package br.ufrpe.geekMart.classesBasicas;



public class Categoria {
	private String[] categorias = new String[100];


	public Categoria() {
		categorias[0] = "Figuras e Estatuas";
		categorias[1] = "Games";
		categorias[2] = "Model Kit";
		categorias[3] = "Cloth Myth";
		categorias[4] = "Hot Toys";
		categorias[5] = "Marvel Select";
		categorias[6] = "Neca";
		categorias[7] = "Play Arts";
		categorias[8] = "Pop Funko";
		categorias[9] = "Outras Estatuas";
		categorias[10] = "Anime e HQ";
		categorias[11] = "Vingadores";
		categorias[12] = "Disney";
		categorias[13] = "Cavaleiros do Zodiaco";
		categorias[14] = "Dragon Ball";
		categorias[15] = "Marvel";
		categorias[16] = "DC";
	}

	public String getCategorias(int i) {
		return categorias[i];
	}

	public void setCategorias(int num, String novaCategoria) {
		this.categorias[num] = novaCategoria;
	}



}




