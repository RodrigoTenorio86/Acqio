package br.com.acqio.errors;

import java.time.LocalDateTime;

public class ResourceNotFoundDetails extends ErrorDetail{
	
	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private LocalDateTime timestamp;
		private String developerMessage;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetails build() {
			ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
			resourceNotFoundDetails.setDeveloperMessage(developerMessage);
			resourceNotFoundDetails.setStatus(status);
			resourceNotFoundDetails.setDetail(detail);
			resourceNotFoundDetails.setTimestamp(timestamp);
			resourceNotFoundDetails.setTitle(title);
			return resourceNotFoundDetails;
		}
	}
}