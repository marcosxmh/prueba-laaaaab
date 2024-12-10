package poo.food;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import poo.config.Config;

public class FoodTest {

    private static class ConcreteFood extends Food {
        private Integer posX;
        private Integer posY;

        public ConcreteFood(Integer posX, Integer posY) {
            this.posX = posX;
            this.posY = posY;
        }

        @Override
        protected void creatingFood() {
            // Implementation for testing purposes
        }

        @Override
        public Integer getPosicionX() {
            return posX;
        }

        @Override
        public Integer getPosicionY() {
            return posY;
        }
    }

    @Test
    public void testRandomNumbers() {
        ConcreteFood food = new ConcreteFood(0, 0);
        Integer min = 0;
        Integer max = 100;

        for (int i = 0; i < 100; i++) {
            Integer randomValue = food.randomNumbers(min, max);
            assertTrue(randomValue >= min && randomValue <= max);
            assertEquals(0, randomValue % Config.squareSize);
        }
    }

    @Test
    public void testGetPosicionX() {
        ConcreteFood food = new ConcreteFood(100, 200);
        assertEquals(100, food.getPosicionX());
    }

    @Test
    public void testGetPosicionY() {
        ConcreteFood food = new ConcreteFood(100, 200);
        assertEquals(200, food.getPosicionY());
    }
}