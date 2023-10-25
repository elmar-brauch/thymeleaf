package de.bsi.thymeleaf.virtual_thread;

public record ThreadInfo(String name, long id, boolean virtual) {
    public static ThreadInfo create(Thread thread) {
        return new ThreadInfo(thread.getName(), thread.threadId(), thread.isVirtual());
    }
}
