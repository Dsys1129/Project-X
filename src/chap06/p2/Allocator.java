package chap06.p2;

@FunctionalInterface
public interface Allocator {
    void allocateEnergy(String place, int amount);
}
