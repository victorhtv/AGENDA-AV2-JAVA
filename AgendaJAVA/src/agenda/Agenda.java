
package agenda;



import java.sql.SQLException;

import java.util.Scanner;




public class Agenda {


 

    public static void main(String[] args) throws SQLException 
{

        int op1, op2, op3;
     
        Scanner in = new Scanner(System.in);

        crud metodo = new crud();

        do
 {

        	System.out.println("****AGENDA****");

        System.out.println("\n Escolha uma opcao");

        System.out.println("\n 1. Novo contato.");

        System.out.println("\n 2. Exibir contatos.");

        System.out.println("\n 3. Pesquisar contato.");

        System.out.println("\n 4. Atualizar contato.");
 
        System.out.println("\n 5. Deletar contato.");

        System.out.println("\n Ou digite 0 para encerrar a sessao.");

        op1 = Integer.parseInt(in.nextLine());


        
    switch(op1) {

            
		case 1:


                	System.out.println("1. Novo Cadastro.");

                	System.out.println("2. Adicionar dados a contato existente.");

                	op2 = Integer.parseInt(in.nextLine());

	                
			if(op2 == 1){

			    crud.cadastrar();

                	} 
			else{

                	    crud.cadastrar2();

               		 }
break;

     	         case 2:

          
                break;


	         case 3:


	                System.out.println("\n 1. Ordenar por Nome.");

               		System.out.println("\n 2. Ordenar por telefone.");
 
               		op2 = Integer.parseInt(in.nextLine());

                	
			if(op2 ==1){

                 		System.out.println("Acao executada.");
	  
                } 
			else
{

                 		System.out.println("Acao executada.");
	  
                }
break;

           	 
		case 4:

                	
			System.out.println("Acao executada.");
	  
              break;


	        case 5:

	 
                System.out.println("Acao executada.");
	  
               break;
                
        
	}

        } while(op1!=0);

    }

 
}
