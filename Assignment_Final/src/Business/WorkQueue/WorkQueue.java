/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public ArrayList<WorkRequest> getIterator() {
        ArrayList<WorkRequest> iteratorArrayList = new ArrayList<WorkRequest>();
        for (int i = workRequestList.size() - 1; i >= 0; i--) {
            WorkRequest request = workRequestList.get(i);
            iteratorArrayList.add(request);
        }
        return iteratorArrayList;
    }
}
