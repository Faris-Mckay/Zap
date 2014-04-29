/**
 *  This file is part of Zap Framework.
 * 
 *  Zap is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Zap is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Zap.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.zap.dors;

import com.dors.job.Job;
import com.dors.job.event.EventExecutor;
import com.dors.job.event.ext.RecurringEvent;
import com.zap.util.Constants;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faris
 */
public class DORSBootstrap {
    
    public static void run() throws Exception {
        Job TaskScheduler = new RecurringEvent(Constants.GAME_EXECUTION_RATE, "Task Force"){
            @Override
            public int execute() {
                DORS.schedule();
                return EXECUTOR_REPEAT;
            }
        };
        try {
            EventExecutor.getSingleton().addEvent(TaskScheduler);
        } catch (Exception ex) {
            Logger.getLogger(DORSBootstrap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
