/*
 * Jinx is Copyright 2010 by Jeremy Brooks
 *
 * This file is part of Jinx.
 *
 * Jinx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jinx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jinx.  If not, see <http://www.gnu.org/licenses/>.
*/
package net.jeremybrooks.jinx.logger;

/**
 * @author jeremyb
 */
public class JinxLogger {

    private static LogInterface logger = null;


    /**
     * @return the logger
     */
    public static LogInterface getLogger() {
        return logger;
    }


    /**
     * @param logger the logger to set
     */
    public static void setLogger(LogInterface logger) {
        if (logger == null) {
            JinxLogger.logger = new DefaultLogger();
        } else {
            JinxLogger.logger = logger;
        }
    }


}
