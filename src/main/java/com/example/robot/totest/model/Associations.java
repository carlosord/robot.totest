package com.example.robot.totest.model;

/**
 * The Class Associations.
 */
public class Associations {

	/**
	 * The Class HasPeople.
	 */
	public static class HasPeople {

		/**
		 * Link.
		 *
		 * @param user
		 *            the user
		 * @param person
		 *            the person
		 */
		public static void link(User user, Person person) {
			user.addPerson(person);
			person.setUser(user);
		}

		/**
		 * Unlink.
		 *
		 * @param user
		 *            the user
		 * @param person
		 *            the person
		 */
		public static void unlink(User user, Person person) {
			person.setUser(null);
			user.removePerson(person);
		}

	}

}
