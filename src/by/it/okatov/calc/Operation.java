package by.it.okatov.calc;

public interface Operation {
    Var add(Var other);

    Var mul(Var other);

    Var sub(Var other);

    Var div(Var other);
}
