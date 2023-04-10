package org.eclipse.collections.api.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public interface Tuple <T1, T2, T3>
        extends Serializable, Comparable<Tuple<T1, T2, T3>>{

        T1 getOne();

        T2 getTwo();

        Optional<T3> getThree();
        
        void put(Map<? super T1, ? super T2, ? super T3 > map);

        
    /*
     * Returns true if value of getOne() is equal to value of getTwo() and getThree() if he exist.
     *
     * @since 11.0
     */
    default boolean isEqual()
    {
        if (this.getThree().isPresent()) {
            return Objects.equals(this.getOne(), this.getTwo()) && Objects.equals(this.getOne() , this.getThree().get());
        }
        else {
            return Objects.equals(this.getOne(), this.getTwo());
        }
    }

    /*
     * Returns true if value of getOne() is the same instance as the value of getTwo() and getThree() if he exist.
     *
     * @since 11.0
     */
    default boolean isSame()
    {
        if (this.getThree().isPresent()) {
            return this.getOne() == this.getTwo() && this.getOne() == this.getThree().get();
        }
        else{
            return this.getOne() == this.getTwo();
        }
    }

    }