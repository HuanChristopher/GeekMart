package br.ufrpe.geekMart;

import br.ufrpe.geekMart.negocio.*;
import br.ufrpe.geekMart.dados.*;
import br.ufrpe.geekMart.classesBasicas.*;
import java.util.Scanner;

public class ClasseTeste {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        Cliente cliente = new Cliente();

        Loja loja = new Loja();
        RepositorioUsuario repo = RepositorioUsuario.getInstancia();
        RepositorioAnuncio anun = RepositorioAnuncio.getInstancia();
        RepositorioLoja loj = RepositorioLoja.getInstancia();
        Fachada fachada = Fachada.getInstancia();
        String nome, cpf, telefone, email;
        String logradouro, numero, bairro, cidade, estado, cep, complemento, senha;
        String login, password;
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
            int choice01 = scan.nextInt();
            switch (choice01) {

                case 1:
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
            scan.next();
            System.out.println("Cliente, digite sua senha:");
            password = scan.nextLine();
            scan.next();
            retorno = loginn.autenticarLoginAdm(password, login);
            if (retorno != true) {
                retorno2 = loginn.autenticarLogin(password, login);
                if (retorno2 == false) {
                    System.out.println("Login falhou.Tente Novamente.");
                } else {
                    System.out.println("Cliente " + fachada.buscaUsuario(login).getNome() + " logado com sucesso.");
                    loop2 = false;
                    ClasseTeste.MenuCliente();
                }
            } else {
                System.out.println("Administrador " + fachada.buscarAdministrador(login).getNome() + " logado com sucesso.");

                loop2 = false;
                ClasseTeste.MenuAdm();
            }

        }
    }


        public static void MenuCliente(){
            Scanner scan = new Scanner(System.in);
            String titulo, cep2, estado2, titulod, titulop, tituloa, tituloj,descricao;
            Anuncio anuncio = new Anuncio();
            boolean loop3 = true;
            double preco;
            Cliente cliente = new Cliente();
            Fachada fachada = Fachada.getInstancia();
            Loja loja = new Loja();
            String telefone, email;
            String logradouro, numero, bairro, cidade, estado, cep, complemento, senha;
            Endereco adress = new Endereco();

            System.out.println("****MENU CLIENTE****");
            while (loop3 != false) {
                System.out.println("[1]CRIAR ANUNCIO\n[2]DELETAR ANUNCIO\n[3]PROCURAR ANUNCIO\n[4]ALTERAR ANUNCIO\n" +
                        "[5]CRIAR LOJA\n[6]DELETAR LOJA\n[7]PROCURAR LOJA\n[8]ALTERAR LOJA\n" +
                        "[9]ALTERAR CADASTRO\n[10]MOSTRAR DADOS DO CADASTRO\n[11]MOSTRAR ANUNCIOS");
                int choice03 = scan.nextInt();
                scan.nextInt();
                switch (choice03) {
                    case 1: {
                        anuncio.setCliente(cliente);
                        System.out.println("Informar título do anúncio:");
                        titulo = scan.nextLine();
                        scan.next();
                        anuncio.setTitulo(titulo);
                        System.out.println("Informar preço do anúncio:");
                        preco = scan.nextDouble();
                        scan.nextDouble();
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
                    }


                    case 2: {
                        System.out.println("Informar título do anúncio que será deletado:");
                        titulod = scan.nextLine();
                        scan.next();
                        fachada.removerAnuncio(titulod);
                        System.out.println("~~~ANUNCIO DELETADO~~~");
                        break;
                    }

                    case 3: {
                        System.out.println("Informar título do anúncio que será procurado:");
                        titulop = scan.nextLine();
                        scan.next();
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
                    }

                    case 5: {
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
                        fachada.novaLoja(cliente, loja);
                        System.out.println("~~~LOJA CRIADA~~~");
                        break;
                    }

                    case 6: {
                        System.out.println("Informar nome da loja que será deletada:");
                        titulod = scan.nextLine();
                        scan.next();
                        fachada.removerLoja(titulod);
                        System.out.println("~~~LOJA DELETADA~~~");
                        break;
                    }

                    case 7: {
                        System.out.println("Informar nome da loja que será procurada:");
                        titulop = scan.nextLine();
                        scan.next();
                        Loja tempo = fachada.buscarLoja(titulop);
                        if (tempo != null) {
                            System.out.println("A loja " + tempo.getNome() + " foi encontrada.");
                        } else {
                            System.out.println("A loja não foi encontrada.");
                        }
                        break;

                    }

                    case 8: {
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
                    }

                    case 9: {
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

                    case 10: {

                        cliente.toString();
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
            String  titulod, titulop, nome, cpf;
            boolean loop5 = true,loop6=true;
            Fachada fachada = Fachada.getInstancia();
            String  email;
            String senha;
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
                        scan.next();
                        System.out.println("Adm, digite sua senha:");
                        String password2 = scan.nextLine();
                        scan.next();
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
                                scan.next();
                                fachada.bloquearUsuario(cpfbloc);
                                System.out.println("~~~USUARIO BLOQUEADO~~~");
                                break;
                            }
                            case 2: {
                                System.out.println("Informar título do anúncio que será deletado:");
                                titulod = scan.nextLine();
                                scan.next();
                                fachada.removerAnuncio(titulod);
                                System.out.println("~~~ANUNCIO DELETADO~~~");
                                break;
                            }
                            case 3: {
                                System.out.println("Informar título do anúncio que será procurado:");
                                titulop = scan.nextLine();
                                scan.next();
                                Anuncio temp = fachada.buscarAnuncio(titulop);
                                temp.toString();
                                break;
                            }
                            case 4: {
                                System.out.println("Informar CPF do Cliente que será deletado:");
                                String num = scan.nextLine();
                                scan.next();
                                Usuario t = fachada.buscaUsuario(num);
                                fachada.removerUsuario(t.getCpf());
                                System.out.println("~~~CLIENTE DELETADO~~~");
                                break;
                            }
                            case 5: {
                                System.out.println("Informar CPF do Cliente que será Desbloqueado:");
                                String cpfunbloc = scan.nextLine();
                                scan.next();
                                fachada.desbloquearUsuario(cpfunbloc);
                                System.out.println("~~~USUARIO DESBLOQUEADO~~~");
                                break;
                            }
                            case 6: {
                                System.out.println("Informar CPF do cliente que será procurado:");
                                String num2 = scan.nextLine();
                                scan.next();
                                Usuario t2 = fachada.buscaUsuario(num2);
                                t2.toString();
                                break;
                            }
                            case 7: {
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
                            }
                            case 8: {
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
                            default: {
                                System.out.println("Opção inválida, tente novamente.");
                                break;

                            }
                        }


                    }

                }
            }









