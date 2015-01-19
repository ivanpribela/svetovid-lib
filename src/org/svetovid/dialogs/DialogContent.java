/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.svetovid.dialogs;

/**
 * This is an interface for objects that can be used as content in dialogs. This
 * interface provides a method for retrieving the content component and a method
 * for retrieving user selected value to return when the dialog is closed.
 * 
 * @author Ivan Pribela
 * @version 1.0
 */
public interface DialogContent<T> {

    public Object getContent();

    public T getValue();

}
