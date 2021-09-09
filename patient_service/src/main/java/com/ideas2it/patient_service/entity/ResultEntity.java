package com.ideas2it.patient_service.entity;

/**
 * ResultEntity which represent result for the custom data.
 * 
 * @author Vigneshwaran N
 */
public class ResultEntity {

	boolean result;

	public boolean isResult() {
		return result;
	}

	public ResultEntity() {
	}

	private ResultEntity(ResultEntityBuilder builder) {
		this.result = builder.result;
	}

	public static class ResultEntityBuilder {
		boolean result;

		public ResultEntityBuilder result(boolean result) {
			this.result = result;
			return this;
		}

		public ResultEntity build() {
			ResultEntity entity = new ResultEntity(this);
			return entity;
		}
	}
}
