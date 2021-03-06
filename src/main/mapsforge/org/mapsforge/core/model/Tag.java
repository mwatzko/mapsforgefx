/*
 * Copyright 2010, 2011, 2012 mapsforge.org
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mapsforge.core.model;

import java.io.Serializable;

/**
 * A tag represents an immutable key-value pair.
 */
public class Tag implements Serializable {
        private static final char KEY_VALUE_SEPARATOR = '=';
        private static final long serialVersionUID = 1L;

        /**
         * The key of this tag.
         */
        public final String key;

        /**
         * The value of this tag.
         */
        public final String value;

        /**
         * @param tag
         *            the textual representation of the tag.
         */
        public Tag(String tag) {
                this(tag, tag.indexOf(KEY_VALUE_SEPARATOR));
        }

        /**
         * @param key
         *            the key of the tag.
         * @param value
         *            the value of the tag.
         */
        public Tag(String key, String value) {
                this.key = key;
                this.value = value;
        }

        private Tag(String tag, int splitPosition) {
                this(tag.substring(0, splitPosition), tag.substring(splitPosition + 1));
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                } else if (!(obj instanceof Tag)) {
                        return false;
                }
                Tag other = (Tag) obj;
                if (this.key == null) {
                        if (other.key != null) {
                                return false;
                        }
                } else if (!this.key.equals(other.key)) {
                        return false;
                } else if (this.value == null) {
                        if (other.value != null) {
                                return false;
                        }
                } else if (!this.value.equals(other.value)) {
                        return false;
                }
                return true;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
                result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
                return result;
        }

        @Override
        public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("key=");
                stringBuilder.append(this.key);
                stringBuilder.append(", value=");
                stringBuilder.append(this.value);
                return stringBuilder.toString();
        }
}
