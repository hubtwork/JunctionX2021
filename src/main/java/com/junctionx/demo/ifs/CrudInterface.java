package com.junctionx.demo.ifs;

public interface CrudInterface<Req, Res> {

    Res create(Req request);

    Res read(Long id);

    Res update(Req request);

    void delete(Long id);


}
