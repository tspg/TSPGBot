// --------------------------------------------------------------------------
// Copyright (C) 2012-2013 Best-Ever
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// --------------------------------------------------------------------------

package org.bestever.bebot;

public class AccountType {
	
	/**
	 * Below are the bitmask permissions for userroups
	 **/
	
	/**
	 * Guests are users who are not logged into BestBot or NickServ.
	 */
	public static final int GUEST = 0; // 0
	
	/**
	 * Normal users.
	 */
	public static final int REGISTERED = 1; // 1
	
	/**
	 * A moderator who has access to some more commands.
	 */
	public static final int MODERATOR = 1 << 1; // 2
	
	/**
	 * <code>MODERATOR</code> with more power.
	 */
	public static final int ADMIN = 1 << 2; // 4
	
	/**
	 * Can access other people's RCon passwords.
	 */
	public static final int RCON = 1 << 3; // 8
	
	/**
	 * <code>ADMIN</code> but has permission to use .shell and .terminate
	 */
	public static final int OPERATOR = 1 << 4; // 16
	
	/**
	 * To check for different masks, this method searches to see if you contain one of them.
	 * Usage of this function would be similar to: isAccountType(accountHere, AccountType.ADMIN, AccounType.TRUSTED);
	 * to check if they are either an admin or trusted user
	 * @param accountType The bitmask to check of the account
	 * @param types A list of constants (see AccountType enumerations)
	 * @return True if one of the types is met, false if none are
	 */
	public static boolean isAccountTypeOf(int accountType, int... types) {
		for (int type : types) {
			if ((accountType & type) == type)
				return true;
		}
		// If we didn't find any matches at all
		return false;
	}
}