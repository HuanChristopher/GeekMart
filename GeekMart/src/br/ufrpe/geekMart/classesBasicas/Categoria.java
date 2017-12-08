package br.ufrpe.geekMart.classesBasicas;



public class Categoria {
	private static String[] categorias = new String[100];
	private static int qtCategorias = 16;

	public Categoria() {
		categorias[0] = "Figuras e Estatuas";
		categorias[1] = "Games";
		categorias[2] = "Card Games";
		categorias[3] = "Camisas";
		categorias[4] = "Canecas";
		categorias[5] = "Acessórios";
		categorias[6] = "Cosplay";
		categorias[7] = "Outros"; // Base
		categorias[8] = "Filmes"; //Sub 0,3,4,
		categorias[9] = "Séries"; //Sub 0,3,4,
		categorias[10] = "Animes"; //Sub 0,3,4,
		categorias[11] = "HQs"; //Sub 0,3,4,
		categorias[12] = "Naruto"; //Sub 10
		categorias[13] = "Cavaleiros do Zodiaco"; //Sub 10
		categorias[14] = "Dragon Ball"; //Sub 10
		categorias[15] = "Marvel"; //Sub 11
		categorias[16] = "DC"; //Sub 11
		categorias[17] = "Disney"; //Sub 11
		categorias[18] = "Yugi-Oh"; //Sub 1
		categorias[19] = "Magic";  //Sub 1
		categorias[20] = "Hot Toy";
		categorias[21] = "S.H.Figuarts";
		categorias[22] = "Cloth Myth";
		categorias[23] = "Play Arts";
		categorias[24] = "POP Funko";
		categorias[25] = "Iron Studios";
		categorias[26] = "Breaking Bad";
		categorias[27] = "Star Wars";
		categorias[28] = "Harry Potter";
		categorias[29] = "Senhor dos Anéis";
		categorias[30] =  "Game of Thrones";



	}

	public static String getCategorias(int i) {
		return categorias[i];
	}

	public static void setCategorias (int num, String novaCategoria) {
		categorias[num] = novaCategoria;
		if (num > 16) {
			qtCategorias++;
		}
	}

	public static int encontrarCategoria (String categoria) {
		int i;
		for (i = 0; i < qtCategorias; i++) {
		    if (categoria.equals(categorias[i])) {
		        return i;
            }
        }
        return -1;
	}

}




