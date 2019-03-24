package com.avl.baserecycleviewdatabinding.base.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by AVL on 2/14/19.
 */
public class ListUtils {
    public static List removeDuplicate(List oldData, List insertData) {
        HashSet oldDataSet = new HashSet(oldData);
        List returnData = new ArrayList();
        for (Object o : insertData) {
            if (!oldDataSet.contains(o)) {
                returnData.add(o);
            }
        }
        return returnData;
    }

    public static boolean isListEmpty(List dataList) {
        return dataList == null || dataList.isEmpty();
    }
}
