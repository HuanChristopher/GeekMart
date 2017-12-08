package br.ufrpe.geekMart;

import br.ufrpe.geekMart.negocio.*;
import br.ufrpe.geekMart.dados.*;
import br.ufrpe.geekMart.classesBasicas.*;
import java.util.Scanner;

public class ClasseTeste {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        Cliente cliente = new Cliente();
        Anuncio anuncio = new Anuncio();
        Loja loja = new Loja();
        Fachada fachada = Fachada.getInstancia();
        String nome, cpf, telefone, email;
        String logradouro, numero, bairro, cidade, estado, cep, complemento, senha;
        String login = null, password = null, titulo, cep2, estado2, titulod, titulop, tituloa, tituloj;
        double preco;
        Endereco adress = new Endereco();
        boolean loop = true, loop2 = true;
        ControleDeLogin loginn = ControleDeLogin.getInstancia();
        boolean retorno, retorno2;



        System.out.println("#############################################################");
        System.out.println("##~~~~~~~~~~~~~~~~~~~~~~~GEEKMART~~~~~~~~~~~~~~~~~~~~~~~~~~##");
        System.out.println("#############################################################");


        System.out.println("BEM VINDO AO GEEKMART\nESCOLHA SUA OPÇÃO:");
        while (loop != false) {
            System.out.println("VOCÊ JÁ POSSUI CADASTRO?");
            System.out.println("[1] NÃO\n[2] SIM");
            String schoice01 = scan.nextLine();
            int choice01 = Integer.valueOf(schoice01);

            switch (choice01) {

                case 1:
                    System.out.println("~~~~NOVO CADASTRO DE CLIENTE~~~~");
                    System.out.println("Informar nome do cliente:");
                    nome = scan.nextLine();
                    cliente.setNome(nome);
                    System.out.println("Informar CPF:");
                    cpf = scan.nextLine();
                    cliente.setCpf(cpf);
                    System.out.println("Informar endereço:");
                    System.out.println("A)Logradouro:");
                    logradouro = scan.nextLine();
                    adress.setLogradouro(logradouro);
                    System.out.println("Informar numero:");
                    numero = scan.nextLine();
                    adress.setNumero(numero);
                    System.out.println("Informar bairro:");
                    bairro = scan.nextLine();
                    adress.setBairro(bairro);
                    System.out.println("Informar cidade:");
                    cidade = scan.nextLine();
                    adress.setCidade(cidade);
                    System.out.println("Informar estado:");
                    estado = scan.nextLine();
                    adress.setEstado(estado);
                    System.out.println("Informar CEP:");
                    cep = scan.nextLine();
                    adress.setCep(cep);
                    System.out.println("Informar complemento:");
                    complemento = scan.nextLine();
                    adress.setComplemento(complemento);
                    cliente.setEndereco(adress);
                    System.out.println("Informar telefone:");
                    telefone = scan.nextLine();
                    cliente.setTelefone(telefone);
                    System.out.println("Informar email:");
                    email = scan.nextLine();
                    cliente.setEmail(email);
                    System.out.println("Escolha uma senha:");
                    senha = scan.nextLine();
                    cliente.setSenha(senha);
                    System.out.println("~~CADASTRO COMPLETO~~");
                    fachada.cadastrarUsuario(cliente);
                    System.out.println("Cliente: "+nome);
                    System.out.println("CPF: "+cpf);
                    System.out.println("Endereço: "+logradouro+","+numero+" "+"("+complemento+") "+bairro+" "+cidade+" "+" "+estado+" "+cep+" ");
                    System.out.println("Telefone: "+telefone);
                    System.out.println("Email: "+email);

                    loop = false;
                    break;

                case 2:
                    loop = false;
                    System.out.println("~~~~~~~~~~");
                    break;

                default:
                    System.out.println("~~Opção Incorreta~~");
                    break;
            }
        }

        System.out.println("****FAZER LOGIN****");
        while (loop2 != false) {

            System.out.println("Cliente, digite seu cpf :");
            login = scan.nextLine();
            //scan.next();
            System.out.println("Cliente, digite sua senha:");
            password = scan.nextLine();
           // scan.next();
            retorno = loginn.autenticarLoginAdm(password, login);
            if (retorno != true) {
                retorno2 = loginn.autenticarLogin(password, login);
                if (retorno2 == false) {
                    System.out.println("Login falhou.Tente Novamente.");
                } else {
                    System.out.println("Cliente " + fachada.buscaUsuario(login).getNome() + " logado com sucesso.");
                    loop2 = false;
                    ClasseTeste.MenuCliente(login);
                }
            } else {
                System.out.println("Administrador " + fachada.buscarAdministrador(login).getNome() + " logado com sucesso.");

                loop2 = false;
                ClasseTeste.MenuAdm();
            }

        }
    }


        public static void MenuCliente(String login) {
            Scanner scan = new Scanner(System.in);
            String titulo, titulo2, cep2, estado2, titulod, titulop, tituloa, tituloj, descricao,descricao2,cep3,estado3;
            Anuncio anuncio = new Anuncio();
            boolean loop3 = true;
            double preco,preco2;
            Cliente cliente = new Cliente();
            Fachada fachada = Fachada.getInstancia();
            Loja loja = new Loja();
            loja.setCliente(cliente);
            loja.setAnuncios(cliente.getAnuncios());
            String telefone, email;
            String logradouro, numero, bairro, cidade, estado, cep, complemento, senha,leandro;
            Endereco adress = new Endereco();

            System.out.println("****MENU CLIENTE****");
            while (loop3 != false) {
                System.out.println("[1]CRIAR ANUNCIO\n[2]DELETAR ANUNCIO\n[3]PROCURAR ANUNCIO\n[4]ALTERAR ANUNCIO\n" +
                        "[5]CRIAR LOJA\n[6]DELETAR LOJA\n[7]PROCURAR LOJA\n[8]ALTERAR LOJA\n" +
                        "[9]ALTERAR CADASTRO");
                int choice03 = scan.nextInt();
                scan.nextLine();
                switch (choice03) {
                    case 1: {
                        anuncio.setCliente(cliente);
                        System.out.println("Informar título do anúncio:");
                        titulo = scan.nextLine();
                        anuncio.setTitulo(titulo);
                        System.out.println("Informar preço do anúncio:");
                        preco = scan.nextDouble();
                        leandro = scan.nextLine();
                        anuncio.setPreco(preco);
                        System.out.println("Informar descrição do anúncio:");
                        descricao = scan.nextLine();
                        anuncio.setDescricao(descricao);
                        System.out.println("Informar cep:");
                        cep2 = scan.nextLine();
                        anuncio.setCep(cep2);
                        System.out.println("Informar estado:");
                        estado2 = scan.nextLine();
                        anuncio.setEstado(estado2);
                        //anuncio.getCategoria();
                        fachada.adicionarAnuncio(anuncio);
                        System.out.println("~~~ANUNCIO CRIADO~~~");
                        System.out.println("Título: "+titulo);
                        System.out.println("Preço: "+preco);
                        System.out.println("Descrição: "+descricao);
                        System.out.println("Localidade: Estado "+estado2+" CEP: "+cep2);
                        //System.out.println("Categoria: "+categoria);
                        break;
                    }


                        case 2: {
                                System.out.println("Informar título do anúncio que será deletado:");
                                titulod = scan.nextLine();
                                fachada.removerAnuncio(titulod);
                                System.out.println("~~~ANUNCIO DELETADO~~~");
                                break;
                            }

                        case 3: {
                                System.out.println("Informar título do anúncio que será procurado:");
                                titulop = scan.nextLine();
                                Anuncio temp = fachada.buscarAnuncio(titulop);
                                if (temp != null) {
                                    System.out.println("O anuncio " + temp.getTitulo() + " foi encontrado.");
                                } else {
                                    System.out.println("O anuncio não foi encontrado.");
                                }
                                break;
                            }

                        case 4: {
                                System.out.println("Informar título do anúncio que será alterado:");
                                tituloa = scan.nextLine();
                                Anuncio temp4 = fachada.buscarAnuncio(tituloa);
                                if (temp4 != null) {
                                    System.out.println("Informar novo título do anúncio:");
                                    titulo2 = scan.nextLine();
                                    temp4.setTitulo(titulo2);
                                    System.out.println("Informar novo preço do anúncio:");
                                    preco2 = scan.nextDouble();
                                    String eita = scan.nextLine();
                                    temp4.setPreco(preco2);
                                    System.out.println("Informar nova descrição do anúncio:");
                                    descricao2 = scan.nextLine();
                                    temp4.setDescricao(descricao2);
                                    System.out.println("Informar novo cep:");
                                    cep3 = scan.nextLine();
                                    temp4.setCep(cep3);
                                    System.out.println("Informar novo estado:");
                                    estado3 = scan.nextLine();
                                    temp4.setEstado(estado3);
                                    System.out.println("~~~ANUNCIO ALTERADO~~~");

                                    System.out.println("Título: "+titulo2);
                                    System.out.println("Preço: "+preco2);
                                    System.out.println("Descrição: "+descricao2);
                                    System.out.println("Localidade: Estado "+estado3+" CEP: "+cep3);

                                 } else {
                                 System.out.println("O anuncio não foi encontrado.");
                                  }

                                break;
                            }

                        case 5: {

                                System.out.println("Informar título do loja:");
                                tituloj = scan.nextLine();
                                loja.setNome(tituloj);
                                System.out.println("Informar descrição da loja:");
                                descricao = scan.nextLine();
                                loja.setDescricao(descricao);
                                System.out.println("Informar cep:");
                                cep2 = scan.nextLine();
                                loja.setCep(cep2);
                                System.out.println("Informar estado:");
                                estado2 = scan.nextLine();
                                loja.setEstado(estado2);
                                fachada.novaLoja(login, loja);
                                System.out.println("~~~LOJA CRIADA~~~");
                            System.out.println("Título: "+tituloj);
                            System.out.println("Dono da Loja: "+cliente.getNome());
                            System.out.println("Descrição: "+descricao);
                            System.out.println("Localidade: Estado "+estado2+" CEP: "+cep2);

                                break;
                            }

                        case 6: {

                                fachada.removerLoja(login);
                                System.out.println("~~~LOJA DELETADA~~~");
                                break;
                            }

                        case 7: {
                                System.out.println("Informar nome da loja que será procurada:");
                                titulop = scan.nextLine();
                                Loja tempo = fachada.buscarLoja(titulop);
                                if (tempo != null) {
                                    System.out.println("A loja " + tempo.getNome() + " foi encontrada.");
                                } else {
                                    System.out.println("A loja não foi encontrada.");
                                }
                                break;
                            }

                        case 8: {
                                System.out.println("Informar  título do loja que será alterado:");
                                tituloj = scan.nextLine();
                                Loja tempo = fachada.buscarLoja(tituloj);
                            if (tempo != null) {
                                System.out.println("Informar novo título do loja");
                                String titulon = scan.nextLine();
                                loja.setNome(titulon);
                                System.out.println("Informar nova descrição da loja:");
                                descricao = scan.nextLine();
                                loja.setDescricao(descricao);
                                System.out.println("Informar novo cep:");
                                cep2 = scan.nextLine();
                                loja.setCep(cep2);
                                System.out.println("Informar novo estado:");
                                estado2 = scan.nextLine();
                                loja.setEstado(estado2);
                                System.out.println("~~~LOJA ALTERADA~~~");
                                System.out.println("Título: "+titulon);
                                System.out.println("Dono da Loja: "+cliente.getNome());
                                System.out.println("Descrição: "+descricao);
                                System.out.println("Localidade: Estado "+estado2+" CEP: "+cep2);
                            } else {
                                System.out.println("A loja não foi encontrada.");
                            }
                            break;


                            }

                        case 9: {
                                System.out.println("Informar os dados que serão  alterados:");
                                System.out.println("Informar endereço:");
                                System.out.println("A)Logradouro:");
                                logradouro = scan.nextLine();
                                adress.setLogradouro(logradouro);
                                System.out.println("Informar numero:");
                                numero = scan.nextLine();
                                adress.setNumero(numero);
                                System.out.println("Informar bairro:");
                                bairro = scan.nextLine();
                                adress.setBairro(bairro);
                                System.out.println("Informar cidade:");
                                cidade = scan.nextLine();
                                adress.setCidade(cidade);
                                System.out.println("Informar estado:");
                                estado = scan.nextLine();
                                adress.setEstado(estado);
                                System.out.println("Informar CEP:");
                                cep = scan.nextLine();
                                adress.setCep(cep);
                                System.out.println("Informar complemento:");
                                complemento = scan.nextLine();
                                adress.setComplemento(complemento);
                                cliente.setEndereco(adress);
                                System.out.println("Informar telefone:");
                                telefone = scan.nextLine();
                                cliente.setTelefone(telefone);
                                System.out.println("Informar email:");
                                email = scan.nextLine();
                                cliente.setEmail(email);
                                System.out.println("Escolha uma senha:");
                                senha = scan.nextLine();
                                cliente.setSenha(senha);
                                System.out.println("~~CADASTRO ALTERADO~~");
                            System.out.println("Cliente: "+cliente.getNome());
                            System.out.println("CPF: "+cliente.getCpf());
                            System.out.println("Endereço: "+logradouro+","+numero+" "+"("+complemento+") "+bairro+" "+cidade+" "+" "+estado+" "+cep+" ");
                            System.out.println("Telefone: "+telefone);
                            System.out.println("Email: "+email);
                                break;
                            }


                        default: {
                                System.out.println("Opção inválida, tente novamente.");
                                break;
                            }

                        }
                    }
                }












        public static void MenuAdm(){
            Scanner scan = new Scanner(System.in);
            Fachada fachada = Fachada.getInstancia();
            String titulod, titulop, nome, cpf, email, senha;
            boolean loop5 = true,loop6=true;
            Administrador adm = new Administrador();
            System.out.println("****MENU ADMINISTRADOR****");

                    while (loop5 != false) {
                        adm.setCpf("cpfteste");
                        adm.setSenha("senhateste");
                        adm.setNome("Adm");
                        adm.setEmail("adm@adm");
                        fachada.cadastrarUsuario(adm);
                        System.out.println("Adm, digite seu cpf :");
                        String login2 = scan.nextLine();
                        System.out.println("Adm, digite sua senha:");
                        String password2 = scan.nextLine();
                        boolean al2 = fachada.autenticarLogin(password2, login2);

                        if (al2 == true) {
                            System.out.println("****MENU ADMINISTRADOR****");
                            loop5 = false;
                        } else {
                            System.out.println("*** SENHA OU LOGIN ERRADO****");
                        }
                    }
                    while (loop6 != false) {
                        System.out.println("[1]BLOQUEAR CLIENTE\n[2]DELETAR ANUNCIO\n[3]PROCURAR ANUNCIO\n[4]DELETAR CLIENTE\n" +
                                "[5]DESBLOQUEAR CLIENTE\n[6]PROCURAR CLIENTE\n[7]CADASTRAR NOVO ADM\n" +
                                "[8]ALTERAR CADASTRO");
                        int choice04 = scan.nextInt();
                        scan.next();
                        switch (choice04) {
                            case 1: {
                                System.out.println("Informar CPF do Cliente que será Bloqueado:");
                                String cpfbloc = scan.nextLine();
                                fachada.bloquearUsuario(cpfbloc);
                                System.out.println("~~~USUARIO BLOQUEADO~~~");
                                break;
                            }
                            case 2: {
                                System.out.println("Informar título do anúncio que será deletado:");
                                titulod = scan.nextLine();
                                fachada.removerAnuncio(titulod);
                                System.out.println("~~~ANUNCIO DELETADO~~~");
                                break;
                            }
                            case 3: {
                                System.out.println("Informar título do anúncio que será procurado:");
                                titulop = scan.nextLine();
                                Anuncio temp = fachada.buscarAnuncio(titulop);
                                temp.toString();
                                break;
                            }
                            case 4: {
                                System.out.println("Informar CPF do Cliente que será deletado:");
                                String num = scan.nextLine();
                                Usuario t = fachada.buscaUsuario(num);
                                fachada.removerUsuario(t.getCpf());
                                System.out.println("~~~CLIENTE DELETADO~~~");
                                break;
                            }
                            case 5: {
                                System.out.println("Informar CPF do Cliente que será Desbloqueado:");
                                String cpfunbloc = scan.nextLine();
                                fachada.desbloquearUsuario(cpfunbloc);
                                System.out.println("~~~USUARIO DESBLOQUEADO~~~");
                                break;
                            }
                            case 6: {
                                System.out.println("Informar CPF do cliente que será procurado:");
                                String num2 = scan.nextLine();
                                Usuario t2 = fachada.buscaUsuario(num2);
                                t2.toString();
                                break;
                            }
                            case 7: {
                                System.out.println("~~~~NOVO CADASTRO DE ADM~~~~");
                                System.out.println("Informar nome do ADM:");
                                nome = scan.nextLine();
                                adm.setNome(nome);
                                System.out.println("Informar CPF:");
                                cpf = scan.nextLine();
                                adm.setCpf(cpf);
                                System.out.println("Informar email:");
                                email = scan.nextLine();
                                adm.setEmail(email);
                                System.out.println("Escolha uma senha:");
                                senha = scan.nextLine();
                                adm.setSenha(senha);
                                System.out.println("~~CADASTRO COMPLETO~~");
                                fachada.cadastrarUsuario(adm);
                                break;
                            }
                            case 8: {
                                System.out.println("~~~~ALTERAR CADASTRO DE ADM~~~~");
                                System.out.println("Informar email:");
                                email = scan.nextLine();
                                adm.setEmail(email);
                                System.out.println("Escolha uma senha:");
                                senha = scan.nextLine();
                                adm.setSenha(senha);
                                System.out.println("~~CADASTRO COMPLETO~~");
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida, tente novamente.");
                                break;

                            }
                        }


                    }

                }
            }









