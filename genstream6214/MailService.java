package com.genstream6214;

import java.util.*;
import java.util.function.Consumer;

public class MailService<E> implements Consumer<Message<E>> {

    public MailService() {
        this.mailBox = new CustomMap<>();
    }

    private final CustomMap<String, List<E>> mailBox;

    public CustomMap<String, List<E>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Message message) {
        String to = message.getTo();
        E content = (E) message.getContent();

        List<E> list = this.mailBox.get(to);
        if (list.equals(Collections.emptyList())) {
            ArrayList<E> messages = new ArrayList<>();
            messages.add(content);
            mailBox.put(to, messages);
        } else {
            list.add(content);
        }
    }

    private static class CustomMap<K, V> extends HashMap<K, V> {

        @Override
        public V get(Object key) {
            return super.getOrDefault(key, (V) Collections.emptyList());
        }
    }

}
