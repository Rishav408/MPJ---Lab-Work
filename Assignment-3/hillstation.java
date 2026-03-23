// Hillstations.java
class Hillstations {
    void location() {
        System.out.println("Location: Various Hill Stations in India");
    }

    void famousfood() {
        System.out.println("Famous Food: Local Delicacies");
    }

    void famousfor() {
        System.out.println("Famous for: Scenic Beauty");
    }
}

class Manali extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Manali Food: Siddu and Thukpa");
    }

    @Override
    void famousfor() {
        System.out.println("Manali is famous for: Adventure Sports and Rohtang Pass");
    }
}

class Mussoorie extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Mussoorie Food: Garhwali Cuisine and Momos");
    }

    @Override
    void famousfor() {
        System.out.println("Mussoorie is famous for: Kempty Falls and Mall Road");
    }
}

class Gulmarg extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Gulmarg Food: Rogan Josh and Wazwan");
    }

    @Override
    void famousfor() {
        System.out.println("Gulmarg is famous for: Skiing and Gondola Rides");
    }
}

class MainHillstations {
    public static void main(String[] args) {
        // Calling methods using Parent Class reference (Dynamic Method Dispatch)
        Hillstations h;

        System.out.println("--- Manali ---");
        h = new Manali(); // Reference to Manali object
        h.famousfood();   // Invokes Manali's version 
        h.famousfor();

        System.out.println("\n--- Mussoorie ---");
        h = new Mussoorie(); 
        h.famousfood();
        h.famousfor();

        System.out.println("\n--- Gulmarg ---");
        h = new Gulmarg();
        h.famousfood();
        h.famousfor();
    }
}