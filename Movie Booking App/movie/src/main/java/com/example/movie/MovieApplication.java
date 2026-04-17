package com.example.movie;

import java.util.Scanner;

import com.example.movie.dao.MemberDAO;
import com.example.movie.dao.MovieDAO;
import com.example.movie.model.Member;
import com.example.movie.model.Movie;

public class MovieApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MovieDAO mdao = new MovieDAO();
		MemberDAO memdao = new MemberDAO();

		while (true) {

			System.out.println("\n1.Add Movie");
			System.out.println("2.Show Movies");
			System.out.println("3.Search Movie");
			System.out.println("4.Update Price");
			System.out.println("5.Delete Movie");
			System.out.println("6.Add Member");
			System.out.println("7.Show Members");
			System.out.println("8.Search Member");
			System.out.println("9.Delete Member");
			System.out.println("10.Book Ticket");
			System.out.println("11.Cancel Ticket");
			System.out.println("12.Show Booking");
			System.out.println("13.Total Amount");
			System.out.println("0.Exit");

			int ch = sc.nextInt();

			switch (ch) {

				case 1:
					Movie m = new Movie();
					System.out.println("Enter ID, Name, Price, Seats");
					m.setMovieId(sc.nextInt());
					m.setMovieName(sc.next());
					m.setPrice(sc.nextDouble());
					m.setSeats(sc.nextInt());
					mdao.addMovie(m);
					break;

				case 2:
					mdao.showMovies();
					break;

				case 3:
					System.out.println("Enter Movie ID");
					mdao.searchMovie(sc.nextInt());
					break;

				case 4:
					System.out.println("Enter ID and New Price");
					mdao.updatePrice(sc.nextInt(), sc.nextDouble());
					break;

				case 5:
					System.out.println("Enter Movie ID");
					mdao.deleteMovie(sc.nextInt());
					break;

				case 6:
					Member mem = new Member();
					System.out.println("Enter ID, Name, MovieID, Tickets");
					mem.setMemberId(sc.nextInt());
					mem.setMemberName(sc.next());
					mem.setMovieId(sc.nextInt());
					mem.setTickets(sc.nextInt());
					memdao.addMember(mem);
					break;

				case 7:
					memdao.showMembers();
					break;

				case 8:
					System.out.println("Enter Member ID");
					memdao.searchMember(sc.nextInt());
					break;

				case 9:
					System.out.println("Enter Member ID");
					memdao.deleteMember(sc.nextInt());
					break;

				case 10:
					System.out.println("Booking...");

					break;

				case 0:
					System.exit(0);
			}
		}
	}
}