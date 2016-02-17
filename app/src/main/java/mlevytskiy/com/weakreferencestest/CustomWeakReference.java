package mlevytskiy.com.weakreferencestest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by max on 17.02.16.
 */
public class CustomWeakReference<T> extends WeakReference<T> {

    public CustomWeakReference(T r) {
        super(r);
    }

    public CustomWeakReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CustomWeakReference) {
            CustomWeakReference reference2 = (CustomWeakReference) obj;
            return (reference2.get() == get());
        } else {
            return false;
        }
    }

    public int hashCode() {
        T obj = get();
        if (obj != null) {
            return obj.hashCode();
        } else {
            return -1;
        }
    }

}
