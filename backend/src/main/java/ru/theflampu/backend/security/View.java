package ru.theflampu.backend.security;

public class View {
    public interface ShortInfo {}
    public interface FullIInfo extends ShortInfo {}
    public interface EditInfo extends FullIInfo {}

    public interface ProfileInfo extends ShortInfo{}
}
