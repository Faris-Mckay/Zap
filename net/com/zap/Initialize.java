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
package com.zap;

import com.zap.util.Constants;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.util.HashedWheelTimer;

/**
 *
 * @author Faris
 */
public class Initialize {
    
    /**
     * Constructor binds Netty Bootstrap
     */
    public Initialize() {
        ServerBootstrap serverBootstrap = new ServerBootstrap (new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
        serverBootstrap.setPipelineFactory (new PipelineFactory(new HashedWheelTimer()));
        try {
            serverBootstrap.bind (new InetSocketAddress(Constants.SERVER_PORT));
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    

}
