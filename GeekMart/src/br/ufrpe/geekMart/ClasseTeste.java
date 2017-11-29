package br.ufrpe.geekMart;

import br.ufrpe.geekMart.negocio.*;
import br.ufrpe.geekMart.dados.*;
import br.ufrpe.geekMart.classesBasicas.*;
import java.util.Scanner;

public class ClasseTeste {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Administrador adm = new Administrador();
        Cliente cliente = new Cliente();
        Anuncio anuncio = new Anuncio();
        Loja loja = new Loja();
        RepositorioUsuario repo = RepositorioUsuario.getInstancia();
        RepositorioAnuncio anun = RepositorioAnuncio.getInstancia();
        RepositorioLoja loj = RepositorioLoja.getInstancia();
        Fachada fachada = Fachada.getInstancia();
        String nome, cpf, telefone, email, descricao;
        String logradouro, numero, bairro, cidade,estado,cep,complemento, senha;
        String login,password,titulo,cep2,estado2,titulod,titulop,tituloa,tituloj;
        double preco;
        Endereco adress = new Endereco();


        System.out.println("#############################################################");
        System.out.println("##~~~~~~~~~~~~~~~~~~~~~~~GEEKMART~~~~~~~~~~~~~~~~~~~~~~~~~~##");
        System.out.println("#############################################################");

        System.out.println("BEM VINDO AO GEEKMART\nESCOLHA SUA OPÇÃO:");
        System.out.println("VOCÊ JÁ POSSUI CADASTRO?");
        System.out.println("[1] SIM\n[2] NÃO");
        int choice01 = scan.nextInt();
        switch(choice01){

            case 2:
            System.out.println("~~~~NOVO CADASTRO DE CLIENTE~~~~");
            System.out.println("Informar nome do cliente:");
            nome = scan.nextLine();
            scan.next();
            cliente.setNome(nome);
            System.out.println("Informar CPF:");
            cpf = scan.nextLine();
            scan.next();
            cliente.setCpf(cpf);
            System.out.println("Informar endereço:");
            System.out.println("A)Logradouro:");
            logradouro = scan.nextLine();
            scan.next();
            adress.setLogradouro(logradouro);
            System.out.println("Informar numero:");
            numero = scan.nextLine();
            scan.next();
            adress.setNumero(numero);
            System.out.println("Informar bairro:");
            bairro = scan.nextLine();
            scan.next();
            adress.setBairro(bairro);
            System.out.println("Informar cidade:");
            cidade = scan.nextLine();
            scan.next();
            adress.setCidade(cidade);
            System.out.println("Informar estado:");
            estado = scan.nextLine();
            scan.next();
            adress.setEstado(estado);
            System.out.println("Informar CEP:");
            cep = scan.nextLine();
            scan.next();
            adress.setCep(cep);
            System.out.println("Informar complemento:");
            complemento = scan.nextLine();
            scan.next();
            adress.setComplemento(complemento);
            cliente.setEndereco(adress);
            System.out.println("Informar telefone:");
            telefone = scan.nextLine();
            scan.next();
            cliente.setTelefone(telefone);
            System.out.println("Informar email:");
            email = scan.nextLine();
            scan.next();
            cliente.setEmail(email);
            System.out.println("Escolha uma senha:");
            senha = scan.nextLine();
            scan.next();
            cliente.setSenha(senha);
            System.out.println("~~CADASTRO COMPLETO~~");
            fachada.cadastrarUsuario(cliente);
            break;
            case 1:
                System.out.println("~~~~~~~~~~");
                break;

                default:
                    System.out.println("~~Opção Incorreta~~");
        }


        System.out.println("****FAZER LOGIN****");
        System.out.println("ESCOLHA O TIPO DE USUÁRIO:\n[1]CLIENTE\n[2]ADMINISTRADOR");
        int choice02 = scan.nextInt();
        scan.next();
        switch (choice02){
            case 1:
                System.out.println("Digite seu cpf :");
                login = scan.nextLine();
                scan.next();
                System.out.println("Digite sua senha:");
                password = scan.nextLine();
                scan.next();
                boolean al = fachada.autenticarLogin(password,login);

                if(al == true){
                    System.out.println("****MENU CLIENTE****");
                    System.out.println("[1]CRIAR ANUNCIO\n[2]DELETAR ANUNCIO\n[3]PROCURAR ANUNCIO\n[4]ALTERAR ANUNCIO\n" +
                            "[5]CRIAR LOJA\n[6]DELETAR LOJA\n[7]PROCURAR LOJA\n[8]ALTERAR LOJA\n" +
                            "[9]ALTERAR CADASTRO");
                    int choice03 = scan.nextInt();
                    scan.next();
                    switch(choice03){
                        case 1:
                            anuncio.setCliente(cliente);
                            System.out.println("Informar título do anúncio:");
                            titulo = scan.nextLine();
                            scan.next();
                            anuncio.setTitulo(titulo);
                            System.out.println("Informar preço do anúncio:");
                            preco = scan.nextDouble();
                            scan.next();
                            anuncio.setPreco(preco);
                            System.out.println("Informar descrição do anúncio:");
                            descricao = scan.nextLine();
                            scan.next();
                            anuncio.setDescricao(descricao);
                            System.out.println("Informar cep:");
                            cep2 = scan.nextLine();
                            scan.next();
                            anuncio.setCep(cep2);
                            System.out.println("Informar estado:");
                            estado2 = scan.nextLine();
                            scan.next();
                            anuncio.setEstado(estado2);
                            //anuncio.getCategoria();
                            fachada.adicionarAnuncio(anuncio);
                            System.out.println("~~~ANUNCIO CRIADO~~~");
                            break;

                        case 2:
                            System.out.println("Informar título do anúncio que será deletado:");
                            titulod = scan.nextLine();
                            scan.next();
                            fachada.removerAnuncio(titulod);
                            System.out.println("~~~ANUNCIO DELETADO~~~");
                            break;

                        case 3:
                            System.out.println("Informar título do anúncio que será procurado:");
                            titulop = scan.nextLine();
                            scan.next();
                            Anuncio temp = fachada.buscarAnuncio(titulop);
                            temp.toString();
                            break;

                        case 4:
                            System.out.println("Informar título do anúncio que será alterado:");
                            tituloa = scan.nextLine();
                            scan.next();
                            System.out.println("Informar título do anúncio:");
                            titulo = scan.nextLine();
                            scan.next();
                            fachada.buscarAnuncio(tituloa).setTitulo(titulo);
                            System.out.println("Informar preço do anúncio:");
                            preco = scan.nextDouble();
                            scan.next();
                            fachada.buscarAnuncio(tituloa).setPreco(preco);
                            System.out.println("Informar descrição do anúncio:");
                            descricao = scan.nextLine();
                            scan.next();
                            fachada.buscarAnuncio(tituloa).setDescricao(descricao);
                            System.out.println("Informar cep:");
                            cep2 = scan.nextLine();
                            scan.next();
                            fachada.buscarAnuncio(tituloa).setCep(cep2);
                            System.out.println("Informar estado:");
                            estado2 = scan.nextLine();
                            scan.next();
                            fachada.buscarAnuncio(tituloa).setEstado(estado2);
                            System.out.println("~~~ANUNCIO ALTERADO~~~");
                            break;

                        case 5:
                            loja.setCliente(cliente);
                            loja.setAnuncios(cliente.getAnuncios());
                            System.out.println("Informar título do loja:");
                            tituloj = scan.nextLine();
                            scan.next();
                            loja.setNome(tituloj);
                            System.out.println("Informar descrição da loja:");
                            descricao = scan.nextLine();
                            scan.next();
                            loja.setDescricao(descricao);
                            System.out.println("Informar cep:");
                            cep2 = scan.nextLine();
                            scan.next();
                            loja.setCep(cep2);
                            System.out.println("Informar estado:");
                            estado2 = scan.nextLine();
                            scan.next();
                            loja.setEstado(estado2);
                            fachada.novaLoja(cliente,loja);
                            System.out.println("~~~LOJA CRIADA~~~");
                            break;

                        case 6:
                            System.out.println("Informar nome da loja que será deletada:");
                            titulod = scan.nextLine();
                            scan.next();
                            fachada.removerLoja(titulod);
                            System.out.println("~~~LOJA DELETADA~~~");
                            break;

                        case 7:
                            System.out.println("Informar nome da loja que será procurada:");
                            titulop = scan.nextLine();
                            scan.next();
                            Loja tempo = fachada.buscarLoja(titulop);
                            tempo.toString();
                            break;

                        case 8:
                            System.out.println("Informar nome da loja que será alterada:");
                            tituloa = scan.nextLine();
                            scan.next();
                            System.out.println("Informar título do loja:");
                            tituloj = scan.nextLine();
                            scan.next();
                            fachada.buscarLoja(tituloa).setNome(tituloj);
                            System.out.println("Informar descrição da loja:");
                            descricao = scan.nextLine();
                            scan.next();
                            fachada.buscarLoja(tituloa).setDescricao(descricao);
                            System.out.println("Informar cep:");
                            cep2 = scan.nextLine();
                            scan.next();
                            fachada.buscarLoja(tituloa).setCep(cep2);
                            System.out.println("Informar estado:");
                            estado2 = scan.nextLine();
                            scan.next();
                            fachada.buscarLoja(tituloa).setEstado(estado2);
                            System.out.println("~~~LOJA ALTERADA~~~");
                            break;

                        case 9:
                            System.out.println("Informar os dados que serão  alterados:");
                            System.out.println("Informar endereço:");
                            System.out.println("A)Logradouro:");
                            logradouro = scan.nextLine();
                            scan.next();
                            adress.setLogradouro(logradouro);
                            System.out.println("Informar numero:");
                            numero = scan.nextLine();
                            scan.next();
                            adress.setNumero(numero);
                            System.out.println("Informar bairro:");
                            bairro = scan.nextLine();
                            scan.next();
                            adress.setBairro(bairro);
                            System.out.println("Informar cidade:");
                            cidade = scan.nextLine();
                            scan.next();
                            adress.setCidade(cidade);
                            System.out.println("Informar estado:");
                            estado = scan.nextLine();
                            scan.next();
                            adress.setEstado(estado);
                            System.out.println("Informar CEP:");
                            cep = scan.nextLine();
                            scan.next();
                            adress.setCep(cep);
                            System.out.println("Informar complemento:");
                            complemento = scan.nextLine();
                            scan.next();
                            adress.setComplemento(complemento);
                            cliente.setEndereco(adress);
                            System.out.println("Informar telefone:");
                            telefone = scan.nextLine();
                            scan.next();
                            cliente.setTelefone(telefone);
                            System.out.println("Informar email:");
                            email = scan.nextLine();
                            scan.next();
                            cliente.setEmail(email);
                            System.out.println("Escolha uma senha:");
                            senha = scan.nextLine();
                            scan.next();
                            cliente.setSenha(senha);
                            System.out.println("~~CADASTRO ALTERADO~~");
                            break;
                    }

                }


            case 2:
                System.out.println("Digite seu cpf :");
                String login2 = scan.nextLine();
                scan.next();
                System.out.println("Digite sua senha:");
                String password2 = scan.nextLine();
                scan.next();
                boolean al2 = fachada.autenticarLogin(password2,login2);

                if(al2 == true) {
                    System.out.println("****MENU ADMINISTRADOR****");
                    System.out.println("[1]BLOQUEAR CLIENTE\n[2]DELETAR ANUNCIO\n[3]PROCURAR ANUNCIO\n[4]DELETAR CLIENTE\n" +
                            "[5]DESBLOQUEAR CLIENTE\n[6]PROCURAR CLIENTE\n[7]CADASTRAR NOVO ADM\n" +
                            "[8]ALTERAR CADASTRO");
                    int choice04 = scan.nextInt();
                    scan.next();
                    switch (choice04) {
                        case 1:
                            System.out.println("Informar CPF do Cliente que será Bloqueado:");
                            String cpfbloc = scan.nextLine();
                            scan.next();
                            fachada.bloquearUsuario(cpfbloc);
                            System.out.println("~~~USUARIO BLOQUEADO~~~");
                            break;

                        case 2:
                            System.out.println("Informar título do anúncio que será deletado:");
                            titulod = scan.nextLine();
                            scan.next();
                            fachada.removerAnuncio(titulod);
                            System.out.println("~~~ANUNCIO DELETADO~~~");
                            break;

                        case 3:
                            System.out.println("Informar título do anúncio que será procurado:");
                            titulop = scan.nextLine();
                            scan.next();
                            Anuncio temp = fachada.buscarAnuncio(titulop);
                            temp.toString();
                            break;

                        case 4:
                            System.out.println("Informar CPF do Cliente que será deletado:");
                            String num = scan.nextLine();
                            scan.next();
                            Usuario t = fachada.buscaUsuario(num);
                            fachada.removerUsuario(t.getCpf());
                            System.out.println("~~~CLIENTE DELETADO~~~");
                            break;

                        case 5:
                            System.out.println("Informar CPF do Cliente que será Desbloqueado:");
                            String cpfunbloc = scan.nextLine();
                            scan.next();
                            fachada.desbloquearUsuario(cpfunbloc);
                            System.out.println("~~~USUARIO DESBLOQUEADO~~~");
                            break;

                        case 6:
                            System.out.println("Informar CPF do cliente que será procurado:");
                            String num2 = scan.nextLine();
                            scan.next();
                            Usuario t2 = fachada.buscaUsuario(num2);
                            t2.toString();
                            break;

                        case 7:
                            System.out.println("~~~~NOVO CADASTRO DE ADM~~~~");
                            System.out.println("Informar nome do ADM:");
                            nome = scan.nextLine();
                            scan.next();
                            adm.setNome(nome);
                            System.out.println("Informar CPF:");
                            cpf = scan.nextLine();
                            scan.next();
                            adm.setCpf(cpf);
                            System.out.println("Informar email:");
                            email = scan.nextLine();
                            scan.next();
                            adm.setEmail(email);
                            System.out.println("Escolha uma senha:");
                            senha = scan.nextLine();
                            scan.next();
                            adm.setSenha(senha);
                            System.out.println("~~CADASTRO COMPLETO~~");
                            fachada.cadastrarUsuario(adm);
                            break;

                        case 8:
                            System.out.println("~~~~ALTERAR CADASTRO DE ADM~~~~");
                            System.out.println("Informar email:");
                            email = scan.nextLine();
                            scan.next();
                            adm.setEmail(email);
                            System.out.println("Escolha uma senha:");
                            senha = scan.nextLine();
                            scan.next();
                            adm.setSenha(senha);
                            System.out.println("~~CADASTRO COMPLETO~~");
                            break;

                    }
                }

        }















        }

}
