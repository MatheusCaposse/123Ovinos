package com.ovinos.DTO;

import com.ovinos.entity.Enum.BatchType;

public class UpdateBatchDTO {
   private String id;
   private BatchType batchType;

   public UpdateBatchDTO(){}

    public UpdateBatchDTO(String id, BatchType batchType) {
        this.id = id;
        this.batchType = batchType;
    }

    public String getId() {
        return id;
    }

    public BatchType getBatchType() {
        return batchType;
    }
}
