package com.leon.springinaction.aspect;

import com.leon.springinaction.Encoreable;
import com.leon.springinaction.impl.DefaultEncoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.leon.springincation.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
