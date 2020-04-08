package com.gm.family.ext;

import com.gm.cc.api.AbstractCcHandler;
import com.gm.cc.common.bo.Cc;
import com.gm.cc.framework.interceptor.MessageInterceptor;
import com.gm.cc.framework.listener.SentListener;
import com.gm.cio.framework.Registry;
import com.gm.cio.framework.listener.ClientListener;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * CcHandler.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class CcHandler extends AbstractCcHandler<Cc> {

    public CcHandler(AsynchronousSocketChannel asc) {
        super(asc);
        // 注册1个拦截器
        Registry.registerInterceptor(MessageInterceptor.class, new MessageInterceptor() {});
        // 注册2个监听器
        Registry.registerListener(ClientListener.class, new ClientListener() {});
        Registry.registerListener(SentListener.class, new SentListener() {});
    }
}
