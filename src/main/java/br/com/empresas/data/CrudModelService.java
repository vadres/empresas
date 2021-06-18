package br.com.empresas.data;

import java.util.List;

public interface CrudModelService<D> {
    public D create(D dto);
    public D update(D dto);
    public Integer delete(Integer id);
    public List<D> read(D dto);
}
