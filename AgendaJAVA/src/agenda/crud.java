
package agendacomercial;

import java.sql.SQLException;
import java.util.Scanner;


public class crud extends ConexaoBD {
    public static void cadastrar() throws SQLException 
    {
        
        Scanner in = new Scanner(System.in);
        DadosP dados = new DadosP();
        DadosPr dpr = new DadosPr();
        Telefone tel = new Telefone();
        Email mail = new Email();
        Endereco end = new Endereco();
        
        
        System.out.println("ID:");
        dados.id_dados = Integer.parseInt(in.nextLine()); 
        System.out.println("Nome:");
        dados.nome = in.nextLine();
        System.out.println("Sobrenome:");
        dados.sobrenome = in.nextLine();
        System.out.println("Nome Social (opcional):");
        dados.n_social = in.nextLine();
        System.out.println("Data de nascimento:");
        dados.d_nasc = in.nextLine();
        System.out.println("Idioma (opcional):");
        dados.idioma = in.nextLine();
        
        OpenDatabase();
        String SQL = "INSERT INTO DadosP VALUES(?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, dados.id_dados);
        ps.setString(2, dados.nome);
        ps.setString(3, dados.sobrenome);
        ps.setString(4, dados.n_social);
        ps.setString(5, dados.d_nasc);
        ps.setString(6, dados.idioma);
        ps.execute();
        
        dpr.id_profi = dados.id_dados;
        System.out.println("Empresa:");
        dpr.empresa = in.nextLine();
        System.out.println("Cargo:");
        dpr.cargo = in.nextLine();
        dpr.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO DadosPr VALUES(?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, dpr.id_profi);
        ps.setString(2, dpr.empresa);
        ps.setString(3, dpr.cargo);
        ps.setInt(4, dpr.fk);
        ps.execute();
        
        tel.id_phone = dados.id_dados;
        System.out.println("DDI:");
        tel.ddi = Integer.parseInt(in.nextLine());
        System.out.println("DDD:");
        tel.ddd = Integer.parseInt(in.nextLine());
        System.out.println("Código da Operadora:");
        tel.c_operadora = Integer.parseInt(in.nextLine());
        System.out.println("Número:");
        tel.numero = Integer.parseInt(in.nextLine());
        System.out.println("Tipo:");
        tel.tipo = in.nextLine();
        tel.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Telefone VALUES(?,?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, tel.id_phone);
        ps.setInt(2, tel.ddi);
        ps.setInt(3, tel.ddd);
        ps.setInt(4, tel.c_operadora);
        ps.setInt(5, tel.numero);
        ps.setString(6, tel.tipo);
        ps.setInt(7, tel.fk);
        ps.execute();
        
        mail.id_mail = dados.id_dados;
        System.out.println("E-mail:");
        mail.email = in.nextLine();
        System.out.println("Tipo:");
        mail.tipo = in.nextLine();
        mail.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Email VALUES(?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, mail.id_mail);
        ps.setString(2, mail.email);
        ps.setString(3, mail.tipo);
        ps.setInt(4, mail.fk);
        ps.execute();
        
        end.id_end = dados.id_dados;
        System.out.println("Tipo:");
        end.tipo = in.nextLine();
        System.out.println("Logradouro:");
        end.logradouro = in.nextLine();
        System.out.println("Número:");
        end.num = in.nextLine();
        System.out.println("Complemento:");
        end.compl = in.nextLine();
        System.out.println("Bairro:");
        end.bairro = in.nextLine();
        System.out.println("Cidade:");
        end.cidade = in.nextLine();
        System.out.println("UF:");
        end.uf = in.nextLine();
        System.out.println("País:");
        end.pais = in.nextLine();
        System.out.println("CEP:");
        end.cep = Integer.parseInt(in.nextLine());
        System.out.println("Categoria:");
        end.categoria = in.nextLine();
        end.fk = dados.id_dados;
        
        OpenDatabase();
        SQL = "INSERT INTO Endereco VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, end.id_end);
        ps.setString(2, end.tipo);
        ps.setString(3, end.logradouro);
        ps.setString(4, end.num);
        ps.setString(5, end.compl);
        ps.setString(6, end.bairro);
        ps.setString(7, end.cidade);
        ps.setString(8, end.uf);
        ps.setString(9, end.pais);
        ps.setInt(10, end.cep);
        ps.setString(11, end.categoria);
        ps.setInt(12, end.fk);
        ps.execute();
        ps.close();
        
        conexao.close();
        
        System.out.println("Dados Cadastrados!");
    }
    public static void cadastrar2() throws SQLException
    {
        int op;
        Scanner in = new Scanner(System.in);
        DadosP dados = new DadosP();
        DadosPr dpr = new DadosPr();
        Telefone tel = new Telefone();
        Email mail = new Email();
        Endereco end = new Endereco();
        
        do{
        System.out.println("1. Cadastrar Empresa/cargo.");
        System.out.println("2. Cadastrar telefone.");
        System.out.println("3. Cadastrar e-mail.");
        System.out.println("4. Cadastrar endereço.");
        System.out.println("Ou digite 0 para encerrar.");
        op = Integer.parseInt(in.nextLine());
        
        switch(op)
        {
            case 1:
                  
                  System,out.println("ID:");
                  dpr.id_profi = Integer.parseInt(in.nextLine());
                  System.out.println("Empresa:");
                  dpr.empresa = in.nextLine();
                  System.out.println("Cargo:");
                  dpr.cargo = in.nextLine();
                 
        }    
        } while(op!=0);
    }        
}
