package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		PreparedStatement st =null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner tc = new Scanner(System.in);
		
		//Statement st = null;
		//ResultSet rs = null;
		
		
		String nome = null;
		String email = null;
		String data = null;
		Double salario = null;
		Integer departamento = null;
		
		
		
		
		System.out.println("Quantas Pessoas deseja Inserir?: ");
		int q = tc.nextInt();
		
		int rowsAffected=0;
		
		tc.nextLine();
		
		
		//Função para inserir dados no banco
		
		try {
			for(int i = 0; i<q; i++) {
				
				System.out.println("Nome: ");
				
				nome = tc.nextLine();
				System.out.println("E-mail: ");
				email = tc.nextLine();
				System.out.println("Data de Nascimento: ");
				data = tc.nextLine();
				System.out.println("Salario: ");
				salario = tc.nextDouble();
				System.out.println("Departamento: ");
				tc.nextLine();
				departamento = tc.nextInt();
			
			conn = DB.getConnection();
			st = conn.prepareStatement(
					
					"INSERT INTO seller"
					+"(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+"VALUES "
					+"(?,?,?,?,?)"
					);
			
			
			st.setString(1, nome);
			st.setString(2, email);
			st.setDate(3, new java.sql.Date(sdf.parse(data).getTime()));
			st.setDouble(4, 5000);
			st.setInt(5, departamento);
			
			rowsAffected += st.executeUpdate();
			
			
			}
			System.out.println("---------*********-----------");
			System.out.println("Tudo certo!, Foram Inseridas "+rowsAffected+" linhas");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			
			e.printStackTrace();
			
		} finally {
			DB.closeStatemente(st);
			DB.closeConnection();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 //
		  *Função para retornar valores no banco de dados
		try {
			
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from seller");
					
					
					while(rs.next()) {
						
						//System.out.println(rs.getInt("Id")+" , "+rs.getString("Name"));
						
					System.out.println(rs.getString("Name")+" , "+ rs.getDate("BirthDate") );
						
					}
		
		
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closerResultset(rs);
			DB.closeStatemente(st);
			DB.getConnection();
			
		}
		*/
		
		
		
		
		
		
		
	}

}
