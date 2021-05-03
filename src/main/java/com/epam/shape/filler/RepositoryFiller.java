package com.epam.shape.filler;

import com.epam.shape.entity.Cone;
import com.epam.shape.repository.Repository;

public class RepositoryFiller {

    public void fillRepositoryWithCone(Cone cone) {
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

}
