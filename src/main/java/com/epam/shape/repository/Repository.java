package com.epam.shape.repository;

import com.epam.shape.entity.Cone;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private List<Cone> cones;

    public List<Cone> getCones() {
        return cones;
    }

    public boolean add(Cone cone) {
        return cones.add(cone);
    }

    public boolean addAll(Collection<? extends Cone> c) {
        return cones.addAll(c);
    }

    public boolean remove(Cone element) {
        return cones.remove(element);
    }

    public boolean removeAll(Collection<?> c) {
        return cones.removeAll(c);
    }

    public Cone get(int index) {
        return cones.get(index);
    }

    public Cone set(int index, Cone element) {
        return cones.set(index, element);
    }

    public List<Cone> query(Specification specification) {
        List<Cone> result = null;
        for (Cone cone : cones) {
            if (specification.specify(cone)) {
                result.add(cone);
            }
        }
        return result;
    }

    public List<Cone> queryStream(Specification specification) {
        List<Cone> result = cones.stream().filter(specification::specify).collect(Collectors.toList());
        return result;
    }

    public List<Cone> sort(Comparator<? super Cone> comparator) {
        return cones.stream().sorted(comparator).collect(Collectors.toList());
    }
}
