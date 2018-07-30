package org.fasta.utils;

import java.util.logging.Logger;

public class LogUtil {

	/*
	 * Each SETA component should use its own logger; pluggable services should use
	 * the logger of the component where the service is plugged
	 */
	//this must be used for common operation
	public static final Logger LOGCMN = Logger.getLogger("SETA_CMN");

}
