package ia.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import ia.models.*;

public class AStar<T> {

    private final GrafoAStar<T> graph;


    public AStar (GrafoAStar<T> GrafoAStar) {
        this.graph = GrafoAStar;
    }

    // extend comparator.
    public class NodeComparator implements Comparator<Nodo<T>> {
        public int compare(Nodo<T> nodeFirst, Nodo<T> nodeSecond) {
            if (nodeFirst.getF() > nodeSecond.getF()) return 1;
            if (nodeSecond.getF() > nodeFirst.getF()) return -1;
            return 0;
        }
    } 

    /**
     * Implements the A-star algorithm and returns the path from source to destination
     * 
     * @param source        the source nodeid
     * @param destination   the destination nodeid
     * @return              the path from source to destination
     */
    public List<T> astar(T source, T destination) {
        /**
         * http://stackoverflow.com/questions/20344041/why-does-priority-queue-has-default-initial-capacity-of-11
         */
        final Queue<Nodo<T>> openQueue = new PriorityQueue<Nodo<T>>(11, new NodeComparator()); 

        Nodo<T> sourceNodo = graph.getNodeData(source);
        sourceNodo.setG(0);
        sourceNodo.calcF(destination);
        openQueue.add(sourceNodo);

        final Map<T, T> path = new HashMap<T, T>();
        final Set<Nodo<T>> closedList = new HashSet<Nodo<T>>();

        while (!openQueue.isEmpty()) {
            final Nodo<T> Nodo = openQueue.poll();

            if (Nodo.getNodeId().equals(destination)) { 
                return path(path, destination);
            }

            closedList.add(Nodo);

            for (Entry<Nodo<T>, Conexion> neighborEntry : graph.edgesFrom(Nodo.getNodeId()).entrySet()) {
                Nodo<T> neighbor = neighborEntry.getKey();

                if (closedList.contains(neighbor)) continue;

                double distanceBetweenTwoNodes = neighborEntry.getValue().getValue();
                double tentativeG = distanceBetweenTwoNodes + Nodo.getG();

                if (tentativeG < neighbor.getG()) {
                    neighbor.setG(tentativeG);
                    neighbor.calcF(destination);

                    path.put(neighbor.getNodeId(), Nodo.getNodeId());
                    if (!openQueue.contains(neighbor)) {
                        openQueue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }


    private List<T> path(Map<T, T> path, T destination) {
        assert path != null;
        assert destination != null;

        final List<T> pathList = new ArrayList<T>();
        pathList.add(destination);
        while (path.containsKey(destination)) {
            destination = path.get(destination);
            pathList.add(destination);
        }
        Collections.reverse(pathList);
        return pathList;
    }


    public static void main(String[] args) {
        Map<Estacion, Map<Estacion, Conexion>> hueristic = new HashMap<Estacion, Map<Estacion, Conexion>>();
        // map for A    
        Map<String, Double> mapA = new HashMap<Estacion, Conexion>();
        mapA.put(new Estacion(),  new Conexion(0.0));
        mapA.put("B", 10.0);
        mapA.put("C", 20.0);
        mapA.put("E", 100.0);
        mapA.put("F", 110.0);


        // map for B
        Map<String, Double> mapB = new HashMap<String, Double>();
        mapB.put("A", 10.0);
        mapB.put("B",  0.0);
        mapB.put("C", 10.0);
        mapB.put("E", 25.0);
        mapB.put("F", 40.0);


        // map for C
        Map<String, Double> mapC = new HashMap<String, Double>();
        mapC.put("A", 20.0);
        mapC.put("B", 10.0);
        mapC.put("C",  0.0);
        mapC.put("E", 10.0);
        mapC.put("F", 30.0);


        // map for X
        Map<String, Double> mapX = new HashMap<String, Double>();
        mapX.put("A", 100.0);
        mapX.put("B", 25.0);
        mapX.put("C", 10.0);
        mapX.put("E",  0.0);
        mapX.put("F", 10.0);

        // map for X
        Map<String, Double> mapZ = new HashMap<String, Double>();
        mapZ.put("A", 110.0);
        mapZ.put("B",  40.0);
        mapZ.put("C",  30.0);
        mapZ.put("E", 10.0);
        mapZ.put("F",  0.0);

        hueristic.put("A", mapA);
        hueristic.put("B", mapB);
        hueristic.put("C", mapC);
        hueristic.put("E", mapX);
        hueristic.put("F", mapZ);

        GrafoAStar<String> graph = new GrafoAStar<String>(hueristic);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("E");
        graph.addNode("F");

        graph.addEdge("A", "B",  10);
        graph.addEdge("A", "E", 100);
        graph.addEdge("B", "C", 10);
        graph.addEdge("C", "E", 10);
        graph.addEdge("C", "F", 30);
        graph.addEdge("E", "F", 10);

        AStar<String> aStar = new AStar<String>(graph);

        for (String path : aStar.astar("A", "F")) {
            System.out.println(path);
        }
    }
}
