package com.gm.family.support;

import com.gm.cc.api.AbstractCcHandler;
import com.gm.cc.common.bo.Cc;
import com.gm.cc.framework.interceptor.MessageInterceptor;
import com.gm.cc.framework.listener.SentListener;
import com.gm.cc.framework.message.Message;
import com.gm.cc.framework.message.Msg;
import com.gm.cc.kit.BeanKit;
import com.gm.cc.kit.JsonKit;
import com.gm.cio.framework.Registry;
import com.gm.cio.framework.listener.ClientListener;
import com.gm.cp.protocol.Type;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Message parseMessage(Type type, byte... bytes) {
        String json = new String(bytes);
        Map<String, Object> map = new HashMap<>();
        JsonKit.toMap(map, json);
        Msg msg = BeanKit.obj(map, Msg.class);
        String c = (String) map.get("content");
        msg.content(c.getBytes());
        return msg;
    }

    @Override
    public byte[] wrapMessage(Type type, Message message) {
        return JsonKit.str(message).getBytes();
    }
}
